package net.redcat.metals.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.redcat.metals.blocks.ModBlocks;
import net.redcat.metals.items.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //TITANIUM
        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_RUTILE_BLOCK.get());

        this.add(ModBlocks.RUTILE_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.RUTILE_ORE.get(), ModItems.RAW_RUTILE.get()));
        this.add(ModBlocks.DEEPSLATE_RUTILE_ORE.get(),
        block -> createDiamondLikeOreDrops(ModBlocks.DEEPSLATE_RUTILE_ORE.get(), ModItems.RAW_RUTILE.get()));

        //ALUMINUM
        this.dropSelf(ModBlocks.ALUMINUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_BAUXITE_BLOCK.get());

        this.add(ModBlocks.BAUXITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.BAUXITE_ORE.get(), ModItems.RAW_BAUXITE.get()));
        this.add(ModBlocks.DEEPSLATE_BAUXITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_BAUXITE_ORE.get(), ModItems.RAW_BAUXITE.get()));

        //SILVER
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());

        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createDiamondLikeOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        //Super Sigma Steel
        //STEEL
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());

        //PLATINUM
        this.dropSelf(ModBlocks.PLATINUM_BLOCK.get());

        //BRONZE
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());

        //TIN
        this.dropSelf(ModBlocks.TIN_BLOCK.get());
}

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createDiamondLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}