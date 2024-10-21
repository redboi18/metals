package net.redcat.metals.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.redcat.metals.Metals;
import net.redcat.metals.blocks.ModBlocks;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Metals.MODID);

    public static final RegistryObject<CreativeModeTab> METALS_TAB = CREATIVE_MODE_TABS.register("metals_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BRONZE_BLOCK.get()))
                    .title(Component.translatable("tab.metals_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BRONZE_INGOT.get());
                        pOutput.accept(ModBlocks.BRONZE_BLOCK.get());

                        pOutput.accept(ModItems.STEEL_INGOT.get());
                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());

                        pOutput.accept(ModItems.STEEL_INGOT.get());
                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());

                        pOutput.accept(ModItems.TIN_INGOT.get());
                        pOutput.accept(ModBlocks.TIN_BLOCK.get());

                        pOutput.accept(ModItems.PLATINUM_INGOT.get());

                        pOutput.accept(ModItems.TITANIUM_INGOT.get());
                        pOutput.accept(ModItems.RAW_RUTILE.get());
                        pOutput.accept(ModBlocks.TITANIUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_RUTILE_BLOCK.get());
                        pOutput.accept(ModBlocks.RUTILE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_RUTILE_ORE.get());

                        pOutput.accept(ModItems.ALUMINUM_INGOT.get());
                        pOutput.accept(ModItems.RAW_BAUXITE.get());
                        pOutput.accept(ModBlocks.ALUMINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_BAUXITE_BLOCK.get());
                        pOutput.accept(ModBlocks.BAUXITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_BAUXITE_ORE.get());

                        pOutput.accept(ModItems.SILVER_INGOT.get());
                        pOutput.accept(ModItems.RAW_SILVER.get());
                        pOutput.accept(ModBlocks.SILVER_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SILVER_BLOCK.get());
                        pOutput.accept(ModBlocks.SILVER_BLOCK.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SILVER_ORE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}