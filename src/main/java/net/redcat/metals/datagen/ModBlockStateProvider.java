package net.redcat.metals.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.redcat.metals.Metals;
import net.redcat.metals.blocks.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Metals.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //TITANIUM
        blockWithItem(ModBlocks.TITANIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_RUTILE_BLOCK);
        blockWithItem(ModBlocks.RUTILE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUTILE_ORE);

        //ALUMINUM
        blockWithItem(ModBlocks.ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.RAW_BAUXITE_BLOCK);
        blockWithItem(ModBlocks.BAUXITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_BAUXITE_ORE);

        //SILVER
        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.RAW_SILVER_BLOCK);
        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);

        //STEEL
        blockWithItem(ModBlocks.STEEL_BLOCK);

        //PLATINUM
        blockWithItem(ModBlocks.PLATINUM_BLOCK);

        //PLATINUM
        blockWithItem(ModBlocks.BRONZE_BLOCK);

        //TIN
        blockWithItem(ModBlocks.TIN_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}