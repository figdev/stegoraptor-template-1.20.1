package net.figdev.stegoraptor;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.figdev.stegoraptor.block.ModBlocks;
import net.figdev.stegoraptor.item.ModItems;
import net.figdev.stegoraptor.item.ModItemGroups;
import net.figdev.stegoraptor.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StegoRaptor implements ModInitializer {
	public static final String MOD_ID = "stegoraptor";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
	}
}