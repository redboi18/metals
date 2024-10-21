package net.redcat.metals.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.redcat.metals.Metals;
import net.redcat.metals.blocks.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Metals.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(Tags.Blocks.STONE);


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                //TITANIUM
                .add(ModBlocks.TITANIUM_BLOCK.get(),
                        ModBlocks.RAW_RUTILE_BLOCK.get(),
                        ModBlocks.RUTILE_ORE.get(),
                        ModBlocks.DEEPSLATE_RUTILE_ORE.get(),

                        //ALUMINUM
                        ModBlocks.ALUMINUM_BLOCK.get(),
                        ModBlocks.RAW_BAUXITE_BLOCK.get(),
                        ModBlocks.BAUXITE_ORE.get(),
                        ModBlocks.DEEPSLATE_BAUXITE_ORE.get(),

                        //SILVER
                        ModBlocks.SILVER_BLOCK.get(),
                        ModBlocks.RAW_SILVER_BLOCK.get(),
                        ModBlocks.SILVER_ORE.get(),
                        ModBlocks.DEEPSLATE_SILVER_ORE.get(),

                        //STEEL
                        ModBlocks.STEEL_BLOCK.get(),

                        //PLATINUM
                        ModBlocks.PLATINUM_BLOCK.get(),

                        //BRONZE
                        ModBlocks.BRONZE_BLOCK.get(),

                        //TIN
                        ModBlocks.TIN_BLOCK.get());






        this.tag(BlockTags.NEEDS_IRON_TOOL)
                        //ALUMINUM
                        .add(ModBlocks.ALUMINUM_BLOCK.get(),
                        ModBlocks.RAW_BAUXITE_BLOCK.get(),
                        ModBlocks.BAUXITE_ORE.get(),
                        ModBlocks.DEEPSLATE_BAUXITE_ORE.get(),

                        //SILVER
                        ModBlocks.SILVER_BLOCK.get(),
                        ModBlocks.RAW_SILVER_BLOCK.get(),
                        ModBlocks.SILVER_BLOCK.get(),
                        ModBlocks.DEEPSLATE_SILVER_ORE.get(),

                        //STEEL
                        ModBlocks.STEEL_BLOCK.get(),

                        //PLATINUM
                        ModBlocks.PLATINUM_BLOCK.get(),

                        //BRONZE
                        ModBlocks.BRONZE_BLOCK.get(),

                        //TIN
                        ModBlocks.TIN_BLOCK.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                        //TITANIUM
                        .add(ModBlocks.TITANIUM_BLOCK.get(),
                        ModBlocks.RAW_RUTILE_BLOCK.get(),
                        ModBlocks.RUTILE_ORE.get(),
                        ModBlocks.DEEPSLATE_RUTILE_ORE.get());
    }
}