package com.fabricator77.highlands;

import fabricator77.multiworld.api.IMWWorldType;
import com.fabricator77.highlands.overworld.ChunkProviderHLOverworld;
import com.fabricator77.highlands.overworld.WorldChunkManagerHL;
import com.fabricator77.highlands.worldgen.layer.GenLayerBiomeEdgeHL;
import com.fabricator77.highlands.worldgen.layer.GenLayerBiomeHL;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeHighlands extends WorldType implements IMWWorldType {

    private String name;

    public WorldTypeHighlands(String par2Str) {
        super(par2Str);
        name = par2Str;
    }

    @Override
    public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer) {
        GenLayer ret = new GenLayerBiomeHL(200L, parentLayer, this);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdgeHL(1000L, ret);
        return ret;
    }

    @Override
    public WorldChunkManager getChunkManager(World world) {
        return new WorldChunkManagerHL(world);
    }

    @Override
    public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
        return new ChunkProviderHLOverworld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
    }
}
