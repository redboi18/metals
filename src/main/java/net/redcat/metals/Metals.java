package net.redcat.metals;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.redcat.metals.blocks.ModBlocks;
import net.redcat.metals.items.ModCreativeTabs;
import net.redcat.metals.items.ModItems;
import org.slf4j.Logger;

@Mod(Metals.MODID)
public class Metals {
    public static final String MODID = "metals";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public Metals() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModCreativeTabs.register(modEventBus);

        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::addCreativeNatral);
        modEventBus.addListener(this::addCreativeBuilding);

        BLOCKS.register(modEventBus);

        ITEMS.register(modEventBus);

        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);


        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        //if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        //LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        //Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            //BRONZE
            event.accept(ModItems.BRONZE_INGOT);

            //ALUMINUM
            event.accept(ModItems.ALUMINUM_INGOT);
            event.accept(ModItems.RAW_BAUXITE);

            //TITANIUM
            event.accept(ModItems.TITANIUM_INGOT);
            event.accept(ModItems.RAW_RUTILE);

            //TIN
            event.accept(ModItems.TIN_INGOT);

            //STEEL
            event.accept(ModItems.STEEL_INGOT);

            //SILVER
            event.accept(ModItems.SILVER_INGOT);
            event.accept(ModItems.RAW_SILVER);

            //PLATINUM
            event.accept(ModItems.PLATINUM_INGOT);
        }
    }

    private void addCreativeBuilding(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            //BLOCKS
            event.accept(ModBlocks.TITANIUM_BLOCK);
            event.accept(ModBlocks.ALUMINUM_BLOCK);
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.STEEL_BLOCK);
            event.accept(ModBlocks.PLATINUM_BLOCK);
        }
    }
    private void addCreativeNatral(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            //BLOCKS PT2

            //TITANIUM
            event.accept(ModBlocks.RAW_RUTILE_BLOCK);
            event.accept(ModBlocks.RUTILE_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUTILE_ORE);

            //ALUMINUM
            event.accept(ModBlocks.RAW_BAUXITE_BLOCK);
            event.accept(ModBlocks.BAUXITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_BAUXITE_ORE);

            //SILVER
            event.accept(ModBlocks.RAW_SILVER_BLOCK);
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.DEEPSLATE_SILVER_ORE);

        }
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
