package com.fabricator77.highlands.worldgen.layer_old;

import org.apache.logging.log4j.Level;

import com.fabricator77.highlands.Highlands;
import com.fabricator77.highlands.Logs;
import com.fabricator77.highlands.api.HighlandsBiomes;
import com.fabricator77.highlands.integration.BoPBiomeLayerHelper;

import com.google.common.collect.ObjectArrays;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerEdge;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class GenLayerBiomeHL extends GenLayer
{
    private BiomeEntry[] hotBiomes; // field_151623_c
    private BiomeEntry[] warmBiomes; // field_151621_d
    private BiomeEntry[] coolBiomes; // field_151622_e
    private BiomeEntry[] iceBiomes;  // field_151620_f

    public GenLayerBiomeHL(long par1, GenLayer par3GenLayer, WorldType par4WorldType)
    {
        super(par1);
        // Heat biomes
        this.hotBiomes = new BiomeEntry[] {
        	new BiomeEntry(BiomeGenBase.desert, 10), new BiomeEntry(BiomeGenBase.desert, 10), new BiomeEntry(BiomeGenBase.desert, 10),
        	new BiomeEntry(BiomeGenBase.savanna, 10), new BiomeEntry(BiomeGenBase.savanna, 10), new BiomeEntry(BiomeGenBase.plains, 10),
        	new BiomeEntry(BiomeGenBase.mesaPlateau_F, 10) // mod add mesaPlateau_F
        };
        // Warm biomes
        this.warmBiomes = new BiomeEntry[] {
        	new BiomeEntry(BiomeGenBase.forest, 10), new BiomeEntry(BiomeGenBase.roofedForest, 10), new BiomeEntry(BiomeGenBase.extremeHills, 10), new BiomeEntry(BiomeGenBase.plains, 10),
        	new BiomeEntry(BiomeGenBase.birchForest, 10), new BiomeEntry(BiomeGenBase.swampland, 10), new BiomeEntry(BiomeGenBase.jungle, 10) // mod add jungle
        };
        // Cool biomes
        this.coolBiomes = new BiomeEntry[] {
        	new BiomeEntry(BiomeGenBase.forest, 10), new BiomeEntry(BiomeGenBase.extremeHills, 10), new BiomeEntry(BiomeGenBase.taiga, 10), new BiomeEntry(BiomeGenBase.plains, 10),
        	new BiomeEntry(BiomeGenBase.megaTaiga, 10) // mod add megaTaiga
        };
        // Ice Biomes
        this.iceBiomes = new BiomeEntry[] {
        	new BiomeEntry(BiomeGenBase.icePlains, 10), new BiomeEntry(BiomeGenBase.icePlains, 10), new BiomeEntry(BiomeGenBase.icePlains, 10), new BiomeEntry(BiomeGenBase.coldTaiga, 10)
        };
        this.parent = par3GenLayer;

        if (par4WorldType == WorldType.DEFAULT_1_1)
        {
            this.hotBiomes = new BiomeEntry[] {new BiomeEntry(BiomeGenBase.desert, 10), new BiomeEntry(BiomeGenBase.forest, 10), new BiomeEntry(BiomeGenBase.extremeHills, 10), new BiomeEntry(BiomeGenBase.swampland, 10), new BiomeEntry(BiomeGenBase.plains, 10), new BiomeEntry(BiomeGenBase.taiga, 10)};
        }
        
        // mod
        if (HighlandsBiomes.biomesForHighlands.size() == 0) {
        	Logs.log(Level.FATAL, "[Highlands] no biomes loaded");
        	return;
        }
        
        addBiome(HighlandsBiomes.woodsMountains, Mode.WARM);
        addBiome(HighlandsBiomes.highlandsb, Mode.WARM);
        addBiome(HighlandsBiomes.tundra, Mode.ICE);
        addBiome(HighlandsBiomes.cliffs, Mode.WARM);
        addBiome(HighlandsBiomes.pinelands, Mode.WARM);
        addBiome(HighlandsBiomes.autumnForest, Mode.WARM);
        addBiome(HighlandsBiomes.alps, Mode.ICE);
        addBiome(HighlandsBiomes.tallPineForest, Mode.WARM);
        addBiome(HighlandsBiomes.meadow, Mode.WARM);
        addBiome(HighlandsBiomes.savannah, Mode.HEAT);       
        addBiome(HighlandsBiomes.tropics, Mode.HEAT);
        addBiome(HighlandsBiomes.outback, Mode.HEAT);
        addBiome(HighlandsBiomes.woodlands, Mode.WARM);
        addBiome(HighlandsBiomes.bog, Mode.COOL);
        addBiome(HighlandsBiomes.redwoodForest, Mode.WARM);
        addBiome(HighlandsBiomes.dunes, Mode.HEAT);
        addBiome(HighlandsBiomes.lowlands, Mode.WARM);
        addBiome(HighlandsBiomes.sahel, Mode.WARM);
        addBiome(HighlandsBiomes.birchHills, Mode.WARM);
        addBiome(HighlandsBiomes.tropicalIslands, Mode.HEAT);
        addBiome(HighlandsBiomes.rainforest, Mode.HEAT);
        addBiome(HighlandsBiomes.estuary, Mode.WARM);
        addBiome(HighlandsBiomes.badlands, Mode.HEAT);
        addBiome(HighlandsBiomes.flyingMountains, Mode.WARM);
        addBiome(HighlandsBiomes.snowMountains, Mode.ICE);
        addBiome(HighlandsBiomes.rockMountains, Mode.WARM);
        addBiome(HighlandsBiomes.desertMountains, Mode.WARM);
        addBiome(HighlandsBiomes.steppe, Mode.COOL);
        addBiome(HighlandsBiomes.glacier, Mode.ICE);
        
        if (BoPBiomeLayerHelper.biomesOPlentyInstalled()) {
        	hotBiomes = BoPBiomeLayerHelper.getHotBiomes(hotBiomes);
        	warmBiomes = BoPBiomeLayerHelper.getWarmBiomes(warmBiomes);
        	coolBiomes = BoPBiomeLayerHelper.getCoolBiomes(coolBiomes);
        	iceBiomes = BoPBiomeLayerHelper.getIceBiomes(iceBiomes);
        }
        
        //TODO: BiomeManager's 4 biome lists
        //      need to filter out any biomes we already have
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    @Override
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int[] aint = this.parent.getInts(par1, par2, par3, par4);
        int[] aint1 = IntCache.getIntCache(par3 * par4);

        for (int i1 = 0; i1 < par4; ++i1)
        {
            for (int j1 = 0; j1 < par3; ++j1)
            {
                this.initChunkSeed((long)(j1 + par1), (long)(i1 + par2));
                int k1 = aint[j1 + i1 * par3];
                int l1 = (k1 & 3840) >> 8;
                k1 &= -3841;
                
                // if (k1 < 0) k1 = 0; // vanilla bug ??

                if (isBiomeOceanic(k1))
                {
                	if (k1 == 0 && Highlands.improvedOceans && HighlandsBiomes.ocean2 != null) {
                		k1 = HighlandsBiomes.ocean2.biomeID;
                	}
                    aint1[j1 + i1 * par3] = k1;
                }
                else if (k1 == BiomeGenBase.mushroomIsland.biomeID)
                {
                    aint1[j1 + i1 * par3] = k1;
                }
                // plains
                else if (k1 == 1)
                {
                    aint1[j1 + i1 * par3] = this.hotBiomes[this.nextInt(this.hotBiomes.length)].biome.biomeID;
                    // mod
                    if (aint1[j1 + i1 * par3] == BiomeGenBase.mesaPlateau_F.biomeID && this.nextInt(3) == 0) {
                    	aint1[j1 + i1 * par3] = BiomeGenBase.mesaPlateau.biomeID;
                    }
                }
                // desert
                else if (k1 == 2)
                {
                	aint1[j1 + i1 * par3] = this.warmBiomes[this.nextInt(this.warmBiomes.length)].biome.biomeID;
                }
                // extreme hills
                else if (k1 == 3)
                {
                    aint1[j1 + i1 * par3] = this.coolBiomes[this.nextInt(this.coolBiomes.length)].biome.biomeID;
                }
                // forest
                else if (k1 == 4)
                {
                    aint1[j1 + i1 * par3] = this.iceBiomes[this.nextInt(this.iceBiomes.length)].biome.biomeID;
                }
                else
                {
                	// put code for mod Island Biomes here ???
                    aint1[j1 + i1 * par3] = BiomeGenBase.mushroomIsland.biomeID;
                }
            }
        }

        return aint1;
    }
    
    // Default weighting of 10
    public void addBiome (BiomeGenBase biome, Mode mode) {
    	addBiome(biome, 10, mode);
    }
    // Custom mod
    public void addBiome (BiomeGenBase biome, int weight, Mode mode) {
    	if (biome == null) return;
    	switch (mode.ordinal())
        {
            case 0:
            	this.hotBiomes = ObjectArrays.concat(this.hotBiomes, new BiomeEntry(biome, weight)); return;
            default:
            case 1:
            	this.warmBiomes = ObjectArrays.concat(this.warmBiomes, new BiomeEntry(biome, weight)); return;
            case 2:
            	this.coolBiomes = ObjectArrays.concat(this.coolBiomes, new BiomeEntry(biome, weight)); return;
            case 3:
            	this.iceBiomes = ObjectArrays.concat(this.iceBiomes, new BiomeEntry(biome, weight)); return;
        }
    }
    
    public int getWeightedRandomBiomeFromList (BiomeEntry[] list) {
    	int totalWeight = WeightedRandom.getTotalWeight(list);
    	//TODO: choose weighted item from list
    	
    	return 0;
    }
    
    /**
     * returns true if the biomeId is one of the various ocean biomes.
     */
    protected static boolean isBiomeOceanic(int biomeID)
    {
    	if (HighlandsBiomes.ocean2 != null && biomeID == HighlandsBiomes.ocean2.biomeID) {
    		return true;
    	}
        return biomeID == BiomeGenBase.ocean.biomeID || biomeID == BiomeGenBase.deepOcean.biomeID || biomeID == BiomeGenBase.frozenOcean.biomeID;
    }
    
    public static enum Mode
    {
    	HEAT,
    	WARM,
        COOL,
        ICE
    }
}
