package com.fabricator77.highlands;

import com.fabricator77.highlands.api.HighlandsBiomes;
import com.fabricator77.highlands.api.HighlandsBlocks;
import java.io.File;

import cpw.mods.fml.common.Loader;
import fabricator77.multiworld.api.biomeregistry.BoPBiomeSupport;
import com.fabricator77.highlands.integration.HighlandsCompatibilityManager;
import com.fabricator77.highlands.integration.MultiWorldSupport;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "Highlands", name = "Highlands", version = "2.2.0",
        dependencies = "after:Forestry;after:MineFactoryReloaded;after:Thaumcraft;after:BuildCraft|Transport")
public class Highlands {

    public static String modid = "Highlands";

    // The instance of your mod that Forge uses.
    @Instance("Highlands")
    public static Highlands instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "highlands.CommonProxy", serverSide = "highlands.CommonProxy")
    public static CommonProxy proxy;

    //Highlands Worldtypes
    public static WorldType HL;// = (WorldType) new WorldTypeHighlands("Highlands");
    public static WorldType HLLB;// = (WorldType) new WorldTypeHighlands("HighlandsLB");

    public static int HighlandsBiomeSizeDefault;
    public static int HighlandsBiomeSizeLB;

    public static boolean mocreaturescomp = false;
    public static boolean improvedOceans = true;
    public static boolean borderBiomeFlag = true;

    public static boolean skyColorFlag = false;
    public static boolean vanillaBlocksFlag = false;
    public static boolean plantsFlag = true;

    public static int islandRarity = 14;

    public static boolean addBoPbiomes = false;

    public static boolean useOreGens = true;
    public static boolean useGenLayers = true;

    public static CreativeTabs tabHighlands = new HighLandsCreativeTab();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //new settings set-up
        Configuration config = new Configuration(new File(event.getModConfigurationDirectory() + File.separator + "Highlands" + File.separator + "General.cfg"));
        config.load();
        Config.setUpConfig(config);
        config.save();

        Initializer.constructBlocks();
        Initializer.initRecipes();
        for (Block block : HighlandsBlocks.logs) {
            Initializer.setFireProperties(block, 5, 5);
        }
        for (Block block : HighlandsBlocks.leaves) {
            Initializer.setFireProperties(block, 30, 60);
        }
        for (Block block : HighlandsBlocks.plants) {
            Initializer.setFireProperties(block, 60, 100);
        }
        for (Block block : HighlandsBlocks.planks) {
            Initializer.setFireProperties(block, 5, 20);
        }
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        //construct all variables
        HighlandsBiomes.initBiomeArrays();
        Initializer.constructBiomes();
        Initializer.constructSettings();

        //set up sub-biomes
        Initializer.setUpAllSubBiomes();

        new MultiWorldSupport();
        if (Highlands.addBoPbiomes) {
            new BoPBiomeSupport();
        }

        //register event manager
        MinecraftForge.TERRAIN_GEN_BUS.register(new HighlandsEventManager());
        MinecraftForge.EVENT_BUS.register(new HighlandsEventManager());

        // allow player spawning in biomes
        for (BiomeGenBase i : HighlandsBiomes.biomesForDefault) {
            WorldChunkManager.allowedBiomes.add(i);
        }
        if (WorldChunkManager.allowedBiomes.isEmpty()) {
            WorldChunkManager.allowedBiomes.add(HighlandsBiomes.ocean2);
        }

        //initiate all recipes and ore dictionary definitions
        proxy.registerRenderers();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        HL = new WorldTypeHighlands("Highlands");
        HLLB = new WorldTypeHighlands("HighlandsLB");

        MapGenStructureConfig.postInit();

        //BiomeDictionary PostInit
        HighlandsCompatibilityManager.registerBiomesForgeBiomeDict();

        GameRegistry.registerFuelHandler(new HighlandsFuelHandler());

        //Forestry PostInit
        if (Loader.isModLoaded("Forestry")) {
            try {
                HighlandsCompatibilityManager.registerBlocksForestry();
                HighlandsCompatibilityManager.registerRecipesForestry();
            } catch (Exception e) {
                System.err.println("[Highlands] Failed to enable Forestry compatibility because: ");
                e.printStackTrace();
            }
        }

//		//MFR PostInit
//		if (Loader.isModLoaded("MineFactoryReloaded") ){
//			try {
//				HighlandsCompatibilityManager.registerBlocksMFR();
//			}
//			catch( Exception e ) {
//				System.err.println("[Highlands] Failed to enable MFR compatibility because: ");
//				e.printStackTrace();
//			}
//		}
//
        //Thaumcraft PostInit
        if (Loader.isModLoaded("Thaumcraft")) {
            try {
                HighlandsCompatibilityManager.registerBlocksThaumcraft();
            } catch (Exception e) {
                System.err.println("[Highlands] Failed to enable Thaumcraft compatibility because: ");
                e.printStackTrace();
            }
        }
//		
//		//ATG PostInit
//		if (Loader.isModLoaded("ATG")){
//			try {
//				HighlandsCompatibilityManager.registerBiomesATG();
//			}
//			catch( Exception e ) {
//				System.err.println("[Highlands] Failed to enable ATG compatibility because: ");
//				e.printStackTrace();
//			}
//		}
    }
}
