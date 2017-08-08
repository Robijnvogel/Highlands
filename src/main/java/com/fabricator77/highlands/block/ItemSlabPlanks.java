package com.fabricator77.highlands.block;

import com.fabricator77.highlands.api.HighlandsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabPlanks extends ItemSlab
{
    public ItemSlabPlanks(Block block)
    {
        super(block, (BlockSlab)HighlandsBlocks.hlplankhalf, (BlockSlab)HighlandsBlocks.hlplankhalfdouble, false);
        this.setMaxDurability(0);
        this.setHasSubtypes(true);
    }
}
