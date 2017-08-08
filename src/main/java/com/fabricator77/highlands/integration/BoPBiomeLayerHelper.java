package com.fabricator77.highlands.integration;

import com.google.common.collect.ObjectArrays;

import cpw.mods.fml.common.Loader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import biomesoplenty.api.content.BOPCBiomes;

public class BoPBiomeLayerHelper {
	
	public static boolean biomesOPlentyInstalled () {
		return Loader.isModLoaded("BiomesOPlenty");
	}
	
	public static BiomeEntry[] getHotBiomes(BiomeEntry[] list ) {
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.bambooForest, 5));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.brushland, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.canyon, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.lushDesert, 5));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.outback, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.steppe, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.tropicalRainforest, 5));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.wasteland, 3));
		return list;
	}
	
	public static BiomeEntry[] getWarmBiomes(BiomeEntry[] list ) {
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.bayou, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.bog, 7)); //also in Highlands
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.borealForest, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.chaparral, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.coniferousForest, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.deadSwamp, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.deciduousForest, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.fen, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.flowerField, 3));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.heathland, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.highland, 10)); //also in Highlands
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.jadeCliffs, 5));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.lavenderFields, 3));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.lushSwamp, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.marsh, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.mountain, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.mysticGrove, 3));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.originValley, 1));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.prairie, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.rainforest, 5));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.redwoodForest, 7)); //also in Highlands
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.sacredSprings, 3));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.sludgepit, 5));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.temperateRainforest, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.wetland, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.woodland, 10));
		return list;
	}
	
	public static BiomeEntry[] getCoolBiomes(BiomeEntry[] list ) {
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.cherryBlossomGrove, 3));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.crag, 3));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.deadForest, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.fungiForest, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.garden, 3));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.grassland, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.grove, 5));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.mapleWoods, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.meadow, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.moor, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.ominousWoods, 3));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.seasonalForest, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.shield, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.shrubland, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.thicket, 5));
		return list;
	}
	
	public static BiomeEntry[] getIceBiomes(BiomeEntry[] list ) {
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.alps, 5)); //also in Highlands
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.arctic, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.snowyConiferousForest, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.frostForest, 7));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.tundra, 7));
		return list;
	}
	
	//TODO: not used yet
	public static BiomeEntry[] getOceanBiomes(BiomeEntry[] list ) {
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.coralReef, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.kelpForest, 10));
		return list;
	}
	
	//TODO: not used yet
	public static BiomeEntry[] getDeepOceanBiomes(BiomeEntry[] list ) {
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.tropics, 10)); //also in Highlands
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.volcano, 10));
		addBiomeToList(list, new BiomeEntry(BOPCBiomes.mangrove, 10));
		return list;
	}
	
	public static int[] getSubBiome (int biomeID) {
		//TODO: how does this work with vanilla subbiomes ?
		if (biomeID == BOPCBiomes.alps.biomeID){
			return new int[]{BOPCBiomes.alpsForest.biomeID};
		}
		if (biomeID == BOPCBiomes.canyon.biomeID){
			return new int[]{BOPCBiomes.canyonRavine.biomeID};
		}
		if (biomeID == BOPCBiomes.arctic.biomeID){
			return new int[]{BOPCBiomes.glacier.biomeID};
		}
		if (biomeID == BOPCBiomes.meadow.biomeID){
			return new int[]{BOPCBiomes.meadowForest.biomeID};
		}
		if (biomeID == BiomeGenBase.desert.biomeID){
			return new int[]{BOPCBiomes.oasis.biomeID};
		}
		if (biomeID == BiomeGenBase.plains.biomeID){
			return new int[]{BOPCBiomes.orchard.biomeID};
		}
		if (biomeID == BOPCBiomes.sludgepit.biomeID){
			return new int[]{BOPCBiomes.quagmire.biomeID, BOPCBiomes.silkglades.biomeID};
		}
		if (biomeID == BiomeGenBase.savanna.biomeID){
			return new int[]{BOPCBiomes.scrubland.biomeID};
		}
		if (biomeID == BiomeGenBase.forest.biomeID){
			return new int[]{BOPCBiomes.spruceWoods.biomeID};
		}
		return new int[]{biomeID};
	}
	
	public static int getRiverBiome (int biomeID) {
		if (BOPCBiomes.lushRiver != null) {
			if (biomeID == BOPCBiomes.bambooForest.biomeID || biomeID == BOPCBiomes.cherryBlossomGrove.biomeID
				|| biomeID == BOPCBiomes.flowerField.biomeID || biomeID == BOPCBiomes.lavenderFields.biomeID
				|| biomeID == BOPCBiomes.lushSwamp.biomeID || biomeID == BOPCBiomes.lushDesert.biomeID
				|| biomeID == BOPCBiomes.meadow.biomeID || biomeID == BOPCBiomes.spruceWoods.biomeID
				|| biomeID == BOPCBiomes.rainforest.biomeID
				|| biomeID == BiomeGenBase.forest.biomeID || biomeID == BiomeGenBase.forestHills.biomeID
				|| biomeID == BiomeGenBase.jungle.biomeID || biomeID == BiomeGenBase.jungleEdge.biomeID
				|| biomeID == BiomeGenBase.jungleHills.biomeID
			) {
				return BOPCBiomes.lushRiver.biomeID;
			}
		}
		if (BOPCBiomes.dryRiver != null) {
			if (biomeID == BOPCBiomes.outback.biomeID || biomeID == BOPCBiomes.steppe.biomeID
				|| biomeID == BiomeGenBase.desert.biomeID || biomeID == BiomeGenBase.desertHills.biomeID
			){
				return BOPCBiomes.dryRiver.biomeID;
			}
		}
		return biomeID;
	}
	
	private static BiomeEntry[] addBiomeToList (BiomeEntry[] list, BiomeEntry biome) {
		if (biome != null) {
			 list = ObjectArrays.concat(list, biome);
		}
		return list;
	}
}
