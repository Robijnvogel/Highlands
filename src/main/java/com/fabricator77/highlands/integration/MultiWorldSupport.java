package com.fabricator77.highlands.integration;

import net.minecraft.world.biome.BiomeGenBase;
import com.fabricator77.highlands.api.HighlandsBiomes;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeEntry;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeRegistry;

public class MultiWorldSupport {
	public MultiWorldSupport() {
		AdvancedBiomeEntry biome;
		String mod = "Highlands";
		
		// sub biomes
		//TODO: register subbiomes inside parent
		if (HighlandsBiomes.valley != null) {//
			biome = new AdvancedBiomeEntry(HighlandsBiomes.valley, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "sub", true);
			
		}
		if (HighlandsBiomes.lake != null) {//
			biome = new AdvancedBiomeEntry(HighlandsBiomes.lake, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "sub", false);
			// add as sub-biome of many biomes
		}
		if (HighlandsBiomes.mesa != null) {// probably kill this also
			biome = new AdvancedBiomeEntry(HighlandsBiomes.mesa, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "sub", true);
			// add as sub-biome of ???
		}
		if (HighlandsBiomes.baldHill != null) {//
			biome = new AdvancedBiomeEntry(HighlandsBiomes.baldHill, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "sub", true);
			// add as sub-biome of forests
		}
		if (HighlandsBiomes.oasis != null) {// goes in deserts
			biome = new AdvancedBiomeEntry(HighlandsBiomes.oasis, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "sub", true);
			// add as sub-biome of sand desert biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.oasis, BiomeGenBase.desert);
		}
		if (HighlandsBiomes.canyon != null) {//
			biome = new AdvancedBiomeEntry(HighlandsBiomes.canyon, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "sub", true);
			// add as sub-biome of steppe biome
			
		}
		
		// hot
		if (HighlandsBiomes.outback != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.outback, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "hot", true);
			// sub biomes
			// AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.mesa, HighlandsBiomes.outback); // NPE
			AdvancedBiomeRegistry.addSubBiomeToBiome(BiomeGenBase.desert, HighlandsBiomes.outback);
		}
		if (HighlandsBiomes.tropics != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.tropics, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "hot", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.lake, HighlandsBiomes.tropics);
		}
		if (HighlandsBiomes.savannah != null) {//To kill anyway.
			biome = new AdvancedBiomeEntry(HighlandsBiomes.savannah, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "hot", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.mesa, HighlandsBiomes.savannah);
		}
		if (HighlandsBiomes.dunes != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.dunes, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "hot", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.oasis, HighlandsBiomes.dunes);
		}
		if (HighlandsBiomes.rainforest != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.rainforest, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "hot", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.baldHill, HighlandsBiomes.rainforest);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.lake, HighlandsBiomes.rainforest);
		}
		if (HighlandsBiomes.badlands != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.badlands, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "hot", true);
		}
		// warm
		if (HighlandsBiomes.highlandsb != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.highlandsb, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.woodlands, HighlandsBiomes.highlandsb);
		}
		if (HighlandsBiomes.cliffs != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.cliffs, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", false);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.valley, HighlandsBiomes.cliffs);
		}
		if (HighlandsBiomes.pinelands != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.pinelands, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.autumnForest, HighlandsBiomes.pinelands);
		}
		if (HighlandsBiomes.autumnForest != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.autumnForest, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.baldHill, HighlandsBiomes.autumnForest);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.lake, HighlandsBiomes.autumnForest);
		}
		if (HighlandsBiomes.tallPineForest != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.tallPineForest, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.alps, HighlandsBiomes.tallPineForest);
			AdvancedBiomeRegistry.addSubBiomeToBiome(BiomeGenBase.frozenRiver, HighlandsBiomes.tallPineForest);
		}
		if (HighlandsBiomes.meadow != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.meadow, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.lake, HighlandsBiomes.meadow);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.birchHills, HighlandsBiomes.meadow);
		}
		if (HighlandsBiomes.woodlands != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.woodlands, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.baldHill, HighlandsBiomes.woodlands);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.lake, HighlandsBiomes.woodlands);
			AdvancedBiomeRegistry.addSubBiomeToBiome(BiomeGenBase.plains, HighlandsBiomes.woodlands);
		}
		if (HighlandsBiomes.redwoodForest != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.redwoodForest, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.highlandsb, HighlandsBiomes.redwoodForest);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.lake, HighlandsBiomes.redwoodForest);
		}
		if (HighlandsBiomes.lowlands != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.lowlands, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", false);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.baldHill, HighlandsBiomes.lowlands);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.lake, HighlandsBiomes.lowlands);
		}
		if (HighlandsBiomes.sahel != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.sahel, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.mesa, HighlandsBiomes.sahel);
			AdvancedBiomeRegistry.addSubBiomeToBiome(BiomeGenBase.desert, HighlandsBiomes.sahel);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.savannah, HighlandsBiomes.sahel);
		}
		if (HighlandsBiomes.birchHills != null) {// probably kill this also
			biome = new AdvancedBiomeEntry(HighlandsBiomes.birchHills, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.meadow, HighlandsBiomes.birchHills);
		}
		if (HighlandsBiomes.estuary != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.estuary, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", false);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.lake, HighlandsBiomes.estuary);
		}
		
		// cool
		if (HighlandsBiomes.bog != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.bog, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "cool", false);
		}
		if (HighlandsBiomes.steppe != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.steppe, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "cool", false);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.canyon, HighlandsBiomes.steppe);
		}
		
        // ice
		if (HighlandsBiomes.tundra != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.tundra, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "ice", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.alps, HighlandsBiomes.tundra);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.tallPineForest, HighlandsBiomes.tundra);
		}
		if (HighlandsBiomes.alps != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.alps, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "ice", true);
			// sub biomes
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.glacier, HighlandsBiomes.alps);
			AdvancedBiomeRegistry.addSubBiomeToBiome(HighlandsBiomes.tallPineForest, HighlandsBiomes.alps);
			AdvancedBiomeRegistry.setRiverBiomeToBiome(HighlandsBiomes.alps, BiomeGenBase.frozenRiver);
		}
		if (HighlandsBiomes.glacier != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.glacier, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "ice", false);
		}
		
		//mountains (note highlands treats these are normal biomes
		if (HighlandsBiomes.desertMountains != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.desertMountains, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "hot", false);
		}
		if (HighlandsBiomes.flyingMountains != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.flyingMountains, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", false);
		}
		if (HighlandsBiomes.rockMountains != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.rockMountains, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", false);
		}
		if (HighlandsBiomes.snowMountains != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.snowMountains, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "ice", false);
		}
		if (HighlandsBiomes.woodsMountains != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.woodsMountains, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "warm", false);
		}
		
		// edge biomes
		if (HighlandsBiomes.shrubland != null) {// intended for use between extremely different temperatures
			biome = new AdvancedBiomeEntry(HighlandsBiomes.shrubland, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "edge", false);
		}
		
		
		     
		//islands
		if (HighlandsBiomes.forestIsland != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.forestIsland, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "island", false);
		}
		if (HighlandsBiomes.tropicalIslands != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.tropicalIslands, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "island", false);
		}
		if (HighlandsBiomes.desertIsland != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.desertIsland, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "island", false);
		}
		if (HighlandsBiomes.volcanoIsland != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.volcanoIsland, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "island", false);
		}
		if (HighlandsBiomes.snowIsland != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.snowIsland, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "island", false);
		}
		if (HighlandsBiomes.windyIsland != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.windyIsland, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "island", false);
		}
		if (HighlandsBiomes.rockIsland != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.rockIsland, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "island", false);
		}
		
		// ocean biomes
		if (HighlandsBiomes.ocean2 != null) {
			biome = new AdvancedBiomeEntry(HighlandsBiomes.ocean2, 10, mod);
			AdvancedBiomeRegistry.addBiome(biome, "ocean", false);
		}
	}
}
