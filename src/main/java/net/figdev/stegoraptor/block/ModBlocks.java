package net.figdev.stegoraptor.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.figdev.stegoraptor.StegoRaptor;
import net.figdev.stegoraptor.block.custom.SoundBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBLock("ruby_block",
        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBLock("raw_ruby_block",
        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_ORE = registerBLock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBLock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2, 5)));
    public static final Block NETHER_RUBY_ORE = registerBLock("nether_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f), UniformIntProvider.create(2, 5)));
    public static final Block END_STONE_RUBY_ORE = registerBLock("end_stone_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f), UniformIntProvider.create(2, 5)));

    public static final Block SOUND_BLOCK = registerBLock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block RUBY_STAIRS = registerBLock("ruby_stairs",
            new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block RUBY_SLAB = registerBLock("ruby_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block RUBY_BUTTON = registerBLock("ruby_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON, 10, true));

    public static final Block RUBY_PRESSURE_PLATE = registerBLock("ruby_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));

    public static final Block RUBY_FENCE = registerBLock("ruby_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RUBY_FENCE_GATE = registerBLock("ruby_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA));
    public static final Block RUBY_WALL = registerBLock("ruby_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));


    public static final Block RUBY_DOOR = registerBLock("ruby_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));
    public static final Block RUBY_TRAPDOOR = registerBLock("ruby_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));


    private static Block registerBLock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(StegoRaptor.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(StegoRaptor.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        StegoRaptor.LOGGER.info("Registering ModBlocks for " + StegoRaptor.MOD_ID);

    }
}
