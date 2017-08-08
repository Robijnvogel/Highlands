package com.fabricator77.highlands.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fabricator77.highlands.Highlands;
import com.fabricator77.highlands.api.IHighlandsBiome;
import com.fabricator77.highlands.worldgen.WorldGenSmallPlants;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class BiomeGenBaseHighlands extends BiomeGenBase implements IHighlandsBiome
{
	
	public ArrayList<BiomeGenBase> subBiomes;

	public BiomeGenBaseHighlands(int id){
		super(id);
		subBiomes = new ArrayList<BiomeGenBase>();
	}
	
	//TODO- could be crashy...
	public WorldGenerator getRandomWorldGenForHighlandsPlants(Random rand){
		return (WorldGenerator)new WorldGenSmallPlants(null);
	}
	
	public void setSpawnLists(List monster, List creature, List waterCreature){
		this.spawnableCreatureList = creature;
		this.spawnableMonsterList = monster;
		this.spawnableWaterCreatureList = waterCreature;
	}
	
}
