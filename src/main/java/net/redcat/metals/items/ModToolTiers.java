package net.redcat.metals.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;
import net.redcat.metals.Metals;

import java.util.List;

public class ModToolTiers {
    public static final Tier TITANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1700, 5f, 4f, 25,
                    Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(ModItems.TITANIUM_INGOT.get())),
            new ResourceLocation(Metals.MODID, "titanium"), List.of(Tiers.NETHERITE), List.of());

}