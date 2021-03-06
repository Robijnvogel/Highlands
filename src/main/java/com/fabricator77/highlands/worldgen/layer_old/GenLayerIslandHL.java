package com.fabricator77.highlands.worldgen.layer_old;

import com.fabricator77.highlands.Highlands;
import com.fabricator77.highlands.api.HighlandsBiomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerIslandHL extends GenLayerIsland
{
    public GenLayerIslandHL(long par1)
    {
        super(par1);
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    @Override
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int[] var5 = IntCache.getIntCache(par3 * par4);

        for (int var6 = 0; var6 < par4; ++var6)
        {
            for (int var7 = 0; var7 < par3; ++var7)
            {
                this.initChunkSeed((long)(par1 + var7), (long)(par2 + var6));
                if (Highlands.improvedOceans) {
                	var5[var7 + var6 * par3] = this.nextInt(10) == 0 ? 1 : HighlandsBiomes.ocean2.biomeID;
                }
                else {
                	var5[var7 + var6 * par3] = this.nextInt(10) == 0 ? 1 : BiomeGenBase.ocean.biomeID;
                }
            }
        }

        if (par1 > -par3 && par1 <= 0 && par2 > -par4 && par2 <= 0)
        {
            var5[-par1 + -par2 * par3] = 1;
        }

        return var5;
    }
}
