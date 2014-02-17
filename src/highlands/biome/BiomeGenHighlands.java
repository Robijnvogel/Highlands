package highlands.biome;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import highlands.api.HighlandsBlocks;
import highlands.HighlandsMain;
import highlands.worldgen.WorldGenHighlandsShrub;
import highlands.worldgen.WorldGenSmallPlants;

public class BiomeGenHighlands extends BiomeGenBaseHighlands
{
	private BiomeDecoratorHighlands biomedec;
	private static final Height biomeHeight = new Height(0.5F, 1.2F);
	
	public BiomeGenHighlands(int par1)
	    {
	        super(par1);
	        
	        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
	        
		    int trees = 3;
		    int grass = 12;
		    int flowers = 0;
		    int plants = 4;
		    this.biomedec = new BiomeDecoratorHighlands(this, trees, grass, flowers, plants);
		    biomedec.generateLakes = true;
		    this.setHeight(biomeHeight);
	        this.temperature = 0.6F;
	        this.rainfall = 0.2F;
	        
	    }
	
	public WorldGenerator getRandomWorldGenForHighlandsPlants(Random rand){
		return (WorldGenerator)(rand.nextInt(3) == 0 ? new WorldGenSmallPlants(HighlandsBlocks.thornbush)
				: (rand.nextInt(2) == 0 ? new WorldGenSmallPlants(HighlandsBlocks.raspberryBush)
				: new WorldGenSmallPlants(HighlandsBlocks.lavender)));
	}

	    /**
	     * Gets a WorldGen appropriate for this biome.
	     */
	    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	    {
	        return (WorldGenerator)(par1Random.nextInt(3) != 0 ? new WorldGenHighlandsShrub(0, 0) : new WorldGenTrees(false, 2 + par1Random.nextInt(3), 0, 0, false));
	    }

	    /**
	     * Gets a WorldGen appropriate for this biome.
	     */
	    public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	    {
	        return new WorldGenTallGrass(Blocks.tallgrass, 1);
	    }

	    public void decorate(World par1World, Random par2Random, BiomeGenBaseHighlands biome, int par3, int par4)
	    {
	        biomedec.decorate(par1World, par2Random, biome, par3, par4);
	        int var5 = 3 + par2Random.nextInt(6);

	        for (int var6 = 0; var6 < var5; ++var6)
	        {
	            int var7 = par3 + par2Random.nextInt(16);
	            int var8 = par2Random.nextInt(28) + 4;
	            int var9 = par4 + par2Random.nextInt(16);
	            Block var10 = par1World.getBlock(var7, var8, var9);

	            if (var10 == Blocks.stone)
	            {
	            	par1World.setBlock(var7, var8, var9, Blocks.emerald_ore, 0, 2);
	            }
	        }
	        
	        biomedec.genOreHighlands(par1World, par2Random, par3, par4, 20, biomedec.coalGen, 0, 128);
	    }
}