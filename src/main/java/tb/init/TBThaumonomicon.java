package tb.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import tb.api.RevolverUpgrade;
import tb.utils.RevolverInfusionRecipe;
import tb.utils.TBConfig;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionEnchantmentRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;

public class TBThaumonomicon {

    public static final String catName = "THAUMICBASES";
    public static final ResourceLocation icon = new ResourceLocation(
        "thaumicbases",
        "textures/thaumonomicon/bases1.png");
    public static final ResourceLocation back = new ResourceLocation(
        "thaumicbases",
        "textures/thaumonomicon/background.png");

    @SuppressWarnings({ "unchecked" })
    public static void setup() {
        OreDictionary.registerOre("pestleAndMortar", new ItemStack(TBItems.mortar, 1, OreDictionary.WILDCARD_VALUE));

        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.pyrofluid, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.FIRE, 16)
                .add(Aspect.MAGIC, 8)
                .add(Aspect.LIGHT, 6));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.ironGreatwood, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.TREE, 1)
                .add(Aspect.METAL, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.plaxSeed),
            new AspectList().add(Aspect.CROP, 1)
                .add(Aspect.CLOTH, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.aurelia, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.AURA, 3)
                .add(Aspect.LIGHT, 1)
                .add(Aspect.SENSES, 1)
                .add(Aspect.LIFE, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.aureliaPetal, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.AURA, 6)
                .add(Aspect.SENSES, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.resource, 1, 5),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.AURA, 6));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.resource, 1, 6),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.HEAL, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.resource, 1, 7),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.MAN, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.tobacco, 1, 0),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.MAN, 1)
                .add(Aspect.ENTROPY, 0));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.mortar, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.TREE, 6)
                .add(Aspect.TOOL, 1));

        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.knoseFragment, 1, 0),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.AIR, 6));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.knoseFragment, 1, 1),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.FIRE, 6));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.knoseFragment, 1, 2),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.WATER, 6));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.knoseFragment, 1, 3),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.EARTH, 6));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.knoseFragment, 1, 4),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.ORDER, 6));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.knoseFragment, 1, 5),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.ENTROPY, 6));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.knoseFragment, 1, 6),
            new AspectList().add(Aspect.PLANT, 1)
                .add(primals(2)));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.knoseFragment, 1, 7),
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.TAINT, 6));

        boolean isFMLoaded = Loader.isModLoaded("ForbiddenMagic");
        Aspect nether = Aspect.FIRE;
        if (isFMLoaded) nether = Aspect.getAspect("infernus");

        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.genLeaves, 1, 0),
            new int[] { 0, 8 },
            new AspectList().add(Aspect.PLANT, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.genLeaves, 1, 1),
            new int[] { 1, 9 },
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.LIFE, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.genLeaves, 1, 2),
            new int[] { 2, 10 },
            new AspectList().add(Aspect.PLANT, 1)
                .add(nether, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.genLeaves, 1, 3),
            new int[] { 3, 11 },
            new AspectList().add(Aspect.PLANT, 1)
                .add(Aspect.ELDRITCH, 1));

        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.genLogs, 1, 0),
            new int[] { 0, 4, 8 },
            new AspectList().add(Aspect.TREE, 3)
                .add(Aspect.HEAL, 1)
                .add(Aspect.LIFE, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.genLogs, 1, 1),
            new int[] { 1, 5, 9 },
            new AspectList().add(Aspect.TREE, 3)
                .add(Aspect.FIRE, 1)
                .add(nether, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.genLogs, 1, 2),
            new int[] { 2, 6, 10 },
            new AspectList().add(Aspect.TREE, 3)
                .add(Aspect.ELDRITCH, 1)
                .add(Aspect.VOID, 1));

        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.sapling, 1, 0),
            new int[] { 0, 8 },
            new AspectList().add(Aspect.PLANT, 3)
                .add(Aspect.GREED, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.sapling, 1, 1),
            new int[] { 1, 9 },
            new AspectList().add(Aspect.PLANT, 3)
                .add(Aspect.LIFE, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.sapling, 1, 2),
            new int[] { 2, 10 },
            new AspectList().add(Aspect.PLANT, 3)
                .add(nether, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBBlocks.sapling, 1, 3),
            new int[] { 3, 11 },
            new AspectList().add(Aspect.PLANT, 3)
                .add(Aspect.ELDRITCH, 1));
        ThaumcraftApi.registerObjectTag(
            new ItemStack(TBItems.fociExperience, 1, 0),
            new AspectList().add(Aspect.METAL, 24)
                .add(Aspect.GREED, 17)
                .add(Aspect.CRYSTAL, 12)
                .add(Aspect.EARTH, 7)
                .add(Aspect.VOID, 5)
                .add(Aspect.HUNGER, 5));

        ResearchCategories.registerCategory(catName, icon, back);

        CrucibleRecipe wool3Rec = new CrucibleRecipe(
            "TB.AdvancedEntropy",
            new ItemStack(Items.string, 3, 0),
            new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.ENTROPY, 1));
        CrucibleRecipe sandstone3Rec = new CrucibleRecipe(
            "TB.AdvancedEntropy",
            new ItemStack(Blocks.sand, 3, 0),
            new ItemStack(Blocks.sandstone, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.ENTROPY, 1));
        CrucibleRecipe blaze3Rec = new CrucibleRecipe(
            "TB.AdvancedEntropy",
            new ItemStack(Items.blaze_powder, 3, 0),
            new ItemStack(Items.blaze_rod, 1, 0),
            new AspectList().add(Aspect.ENTROPY, 1));

        CrucibleRecipe wool4Rec = new CrucibleRecipe(
            "TB.MasterEntropy",
            new ItemStack(Items.string, 4, 0),
            new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.ENTROPY, 1)
                .add(Aspect.CRAFT, 1));
        CrucibleRecipe sandstone4Rec = new CrucibleRecipe(
            "TB.MasterEntropy",
            new ItemStack(Blocks.sand, 4, 0),
            new ItemStack(Blocks.sandstone, 1, OreDictionary.WILDCARD_VALUE),
            new AspectList().add(Aspect.ENTROPY, 1)
                .add(Aspect.CRAFT, 1));
        CrucibleRecipe blaze4Rec = new CrucibleRecipe(
            "TB.MasterEntropy",
            new ItemStack(Items.blaze_powder, 4, 0),
            new ItemStack(Items.blaze_rod, 1, 0),
            new AspectList().add(Aspect.ENTROPY, 1)
                .add(Aspect.CRAFT, 1));

        CrucibleRecipe glassSand = new CrucibleRecipe(
            "TB.StrongEntropy",
            new ItemStack(Blocks.sand, 1, 0),
            "blockGlass",
            new AspectList().add(Aspect.ENTROPY, 1));
        CrucibleRecipe gravelSand = new CrucibleRecipe(
            "TB.StrongEntropy",
            new ItemStack(Blocks.sand, 1, 0),
            new ItemStack(Blocks.gravel),
            new AspectList().add(Aspect.ENTROPY, 1));
        CrucibleRecipe barsIron = new CrucibleRecipe(
            "TB.StrongEntropy",
            new ItemStack(ConfigItems.itemNugget, 3, 0),
            new ItemStack(Blocks.iron_bars),
            new AspectList().add(Aspect.ENTROPY, 1));

        CrucibleRecipe arrows = new CrucibleRecipe(
            "TB.SimpleDublication",
            new ItemStack(Items.arrow, 2, 0),
            new ItemStack(Items.arrow, 1, 0),
            new AspectList().add(Aspect.WEAPON, 1));
        CrucibleRecipe snowball = new CrucibleRecipe(
            "TB.SimpleDublication",
            new ItemStack(Items.snowball, 2, 0),
            new ItemStack(Items.snowball, 1, 0),
            new AspectList().add(Aspect.COLD, 1));
        CrucibleRecipe redstone = new CrucibleRecipe(
            "TB.SimpleDublication",
            new ItemStack(Items.redstone, 2, 0),
            new ItemStack(Items.redstone, 1, 0),
            new AspectList().add(Aspect.MECHANISM, 1)
                .add(Aspect.ENERGY, 1));

        CrucibleRecipe amber = new CrucibleRecipe(
            "TB.Amber",
            new ItemStack(ConfigItems.itemResource, 1, 6),
            new ItemStack(Blocks.sapling, 1, 1),
            new AspectList().add(Aspect.TRAP, 2));
        CrucibleRecipe cinnabar = new CrucibleRecipe(
            "TB.Quicksilver",
            new ItemStack(ConfigItems.itemResource, 3, 3),
            new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1),
            new AspectList().add(Aspect.ORDER, 1)
                .add(Aspect.POISON, 1));
        CrucibleRecipe salisMundis = new CrucibleRecipe(
            "TB.SM",
            new ItemStack(ConfigItems.itemResource, 2, 14),
            new ItemStack(ConfigItems.itemResource, 1, 14),
            new AspectList().add(primals(2))
                .add(Aspect.MAGIC, 3));

        CrucibleRecipe chiseledBricks = new CrucibleRecipe(
            "TB.AlchemyRestoration",
            new ItemStack(Blocks.stonebrick, 1, 3),
            new ItemStack(Blocks.stonebrick, 1, 0),
            new AspectList().add(Aspect.ORDER, 1));
        CrucibleRecipe gravel2Cobble = new CrucibleRecipe(
            "TB.AlchemyRestoration",
            new ItemStack(Blocks.cobblestone, 1, 0),
            new ItemStack(Blocks.gravel, 1, 0),
            new AspectList().add(Aspect.ORDER, 1));
        CrucibleRecipe icePacking = new CrucibleRecipe(
            "TB.AlchemyRestoration",
            new ItemStack(Blocks.packed_ice, 1, 0),
            new ItemStack(Blocks.ice, 1, 0),
            new AspectList().add(Aspect.EARTH, 1)
                .add(Aspect.COLD, 3));

        CrucibleRecipe blazepowderRest = new CrucibleRecipe(
            "TB.Backprocessing",
            new ItemStack(Items.blaze_rod, 1, 0),
            new ItemStack(Items.blaze_powder, 1, 0),
            new AspectList().add(Aspect.ORDER, 6)
                .add(Aspect.FIRE, 3)
                .add(Aspect.MAGIC, 2)
                .add(Aspect.CRAFT, 8)
                .add(Aspect.EXCHANGE, 6)
                .add(Aspect.ENERGY, 3));
        CrucibleRecipe boneRest = new CrucibleRecipe(
            "TB.Backprocessing",
            new ItemStack(Items.bone, 1, 0),
            new ItemStack(Items.dye, 1, 15),
            new AspectList().add(Aspect.ORDER, 2)
                .add(Aspect.SENSES, 6)
                .add(Aspect.CRAFT, 2)
                .add(Aspect.EXCHANGE, 1)
                .add(Aspect.DEATH, 4));
        CrucibleRecipe sugarRest = new CrucibleRecipe(
            "TB.Backprocessing",
            new ItemStack(Items.reeds, 1, 0),
            new ItemStack(Items.sugar, 1, 0),
            new AspectList().add(Aspect.ORDER, 1)
                .add(Aspect.LIFE, 2));
        CrucibleRecipe cactiRest = new CrucibleRecipe(
            "TB.Backprocessing",
            new ItemStack(Blocks.cactus, 1, 0),
            new ItemStack(Items.dye, 1, 2),
            new AspectList().add(Aspect.ORDER, 1)
                .add(Aspect.LIFE, 2)
                .add(Aspect.EARTH, 1));

        CrucibleRecipe pyrofluidRec = new CrucibleRecipe(
            "TB.Pyrofluid",
            new ItemStack(TBItems.pyroBucket, 1, 0),
            new ItemStack(Items.lava_bucket, 1, 0),
            new AspectList().add(Aspect.FIRE, 24)
                .add(Aspect.MAGIC, 8));

        InfusionEnchantmentRecipe elderKnowledgeEnch = new InfusionEnchantmentRecipe(
            "TB.ElderKnowledge",
            TBEnchant.elderKnowledge,
            2,
            new AspectList().add(Aspect.MAGIC, 8)
                .add(Aspect.MIND, 8)
                .add(Aspect.WEAPON, 8),
            new ItemStack[] { new ItemStack(Items.paper, 1, 0), new ItemStack(Items.paper, 1, 0),
                new ItemStack(Items.paper, 1, 0), new ItemStack(ConfigItems.itemZombieBrain, 1, 0),
                new ItemStack(ConfigItems.itemResource, 1, 14) });
        InfusionEnchantmentRecipe elderBaneEnch = new InfusionEnchantmentRecipe(
            "TB.Eldritchbane",
            TBEnchant.eldritchBane,
            2,
            new AspectList().add(Aspect.DEATH, 8)
                .add(Aspect.ELDRITCH, 8)
                .add(Aspect.WEAPON, 8),
            new ItemStack[] { new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.ender_eye, 1, 0),
                new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemResource, 1, 14) });
        InfusionEnchantmentRecipe magicTouchEnch = new InfusionEnchantmentRecipe(
            "TB.MagicTouch",
            TBEnchant.magicTouch,
            2,
            new AspectList().add(Aspect.MAGIC, 8)
                .add(Aspect.AURA, 8)
                .add(Aspect.WEAPON, 8),
            new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemResource, 1, 14),
                new ItemStack(Items.paper, 1, 0) });
        InfusionEnchantmentRecipe vaporisingEnch = new InfusionEnchantmentRecipe(
            "TB.Vaporising",
            TBEnchant.vaporising,
            2,
            new AspectList().add(Aspect.MAGIC, 8)
                .add(Aspect.CRYSTAL, 8)
                .add(Aspect.TRAP, 8),
            new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.diamond, 1, 0) });
        InfusionEnchantmentRecipe taintedEnch = new InfusionEnchantmentRecipe(
            "TB.Tainted",
            TBEnchant.tainted,
            5,
            new AspectList().add(Aspect.TAINT, 16),
            new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 11),
                new ItemStack(ConfigItems.itemResource, 1, 12), new ItemStack(ConfigItems.itemResource, 1, 14) });

        ShapelessArcaneRecipe salisMundusBlockRec = new ShapelessArcaneRecipe(
            "TB.SMB",
            TBBlocks.dustBlock,
            new AspectList().add(primals(1)),
            new Object[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemResource, 1, 14),
                new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemResource, 1, 14),
                new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemResource, 1, 14),
                new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemResource, 1, 14) });

        // thauminite
        CrucibleRecipe thauminiteRec = new CrucibleRecipe(
            "TB.Thauminite",
            new ItemStack(TBItems.resource, 8, 0),
            new ItemStack(ConfigItems.itemResource, 1, 2),
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.CRYSTAL, 8)
                .add(Aspect.MAGIC, 2));

        ShapedArcaneRecipe[] toolsRec = new ShapedArcaneRecipe[10];

        ItemStack tiG = new ItemStack(TBItems.resource, 1, 1);

        toolsRec[0] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteAxe,
            primals(15),
            new Object[] { "##", "#|", " |", '#', tiG, '|', "stickWood" });

        toolsRec[1] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteHoe,
            primals(15),
            new Object[] { "##", " |", " |", '#', tiG, '|', "stickWood" });

        toolsRec[2] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteShovel,
            primals(15),
            new Object[] { "#", "|", "|", '#', tiG, '|', "stickWood" });

        toolsRec[3] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteSword,
            primals(15),
            new Object[] { "#", "#", "|", '#', tiG, '|', "stickWood" });

        toolsRec[4] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteShears,
            primals(15),
            new Object[] { " #", "# ", '#', tiG });

        toolsRec[5] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminitePickaxe,
            primals(15),
            new Object[] { "###", " | ", " | ", '#', tiG, '|', "stickWood" });

        toolsRec[6] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteHelmet,
            primals(25),
            new Object[] { "###", "# #", '#', tiG });

        toolsRec[7] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteChest,
            primals(25),
            new Object[] { "# #", "###", "###", '#', tiG });

        toolsRec[8] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteLeggings,
            primals(25),
            new Object[] { "###", "# #", "# #", '#', tiG });

        toolsRec[9] = new ShapedArcaneRecipe(
            "TB.Thauminite",
            TBItems.thauminiteBoots,
            primals(25),
            new Object[] { "# #", "# #", '#', tiG });

        ShapedArcaneRecipe thauminiteCaps = new ShapedArcaneRecipe(
            "CAP_thauminite",
            new ItemStack(TBItems.resource, 1, 2),
            primals(25),
            new Object[] { "###", "#@#", "@@@", '#', new ItemStack(TBItems.resource, 1, 0), '@',
                new ItemStack(ConfigItems.itemResource, 1, 14) });

        ShapedArcaneRecipe thaumicWandCore = new ShapedArcaneRecipe(
            "ROD_tbthaumium",
            new ItemStack(TBItems.resource, 1, 3),
            primals(50),
            new Object[] { " @#", "@#@", "#@ ", '#', new ItemStack(ConfigItems.itemResource, 1, 2), '@',
                new ItemStack(ConfigItems.itemResource, 1, 14) });

        CrucibleRecipe[] shards = new CrucibleRecipe[6];
        if (Loader.isModLoaded("gregtech")) {

            shards[0] = new CrucibleRecipe(
                "TB.OreDestruction",
                new ItemStack(ConfigItems.itemShard, TBConfig.shardsFromOre, 0),
                new ItemStack(GameRegistry.findBlock("gregtech", "gt.blockores"), 1, 540),
                new AspectList().add(Aspect.ENTROPY, 2)
                    .add(Aspect.MAGIC, 1)
                    .add(Aspect.AIR, 3));

            shards[1] = new CrucibleRecipe(
                "TB.OreDestruction",
                new ItemStack(ConfigItems.itemShard, TBConfig.shardsFromOre, 1),
                new ItemStack(GameRegistry.findBlock("gregtech", "gt.blockores"), 1, 541),
                new AspectList().add(Aspect.ENTROPY, 2)
                    .add(Aspect.MAGIC, 1)
                    .add(Aspect.FIRE, 3));

            shards[2] = new CrucibleRecipe(
                "TB.OreDestruction",
                new ItemStack(ConfigItems.itemShard, TBConfig.shardsFromOre, 2),
                new ItemStack(GameRegistry.findBlock("gregtech", "gt.blockores"), 1, 543),
                new AspectList().add(Aspect.ENTROPY, 2)
                    .add(Aspect.MAGIC, 1)
                    .add(Aspect.WATER, 3));

            shards[3] = new CrucibleRecipe(
                "TB.OreDestruction",
                new ItemStack(ConfigItems.itemShard, TBConfig.shardsFromOre, 3),
                new ItemStack(GameRegistry.findBlock("gregtech", "gt.blockores"), 1, 542),
                new AspectList().add(Aspect.ENTROPY, 2)
                    .add(Aspect.MAGIC, 1)
                    .add(Aspect.EARTH, 3));

            shards[4] = new CrucibleRecipe(
                "TB.OreDestruction",
                new ItemStack(ConfigItems.itemShard, TBConfig.shardsFromOre, 4),
                new ItemStack(GameRegistry.findBlock("gregtech", "gt.blockores"), 1, 545),
                new AspectList().add(Aspect.ENTROPY, 2)
                    .add(Aspect.MAGIC, 1)
                    .add(Aspect.ORDER, 3));

            shards[5] = new CrucibleRecipe(
                "TB.OreDestruction",
                new ItemStack(ConfigItems.itemShard, TBConfig.shardsFromOre, 5),
                new ItemStack(GameRegistry.findBlock("gregtech", "gt.blockores"), 1, 544),
                new AspectList().add(Aspect.MAGIC, 1)
                    .add(Aspect.ENTROPY, 5));
        } else {

            for (int i = 0; i < 6; ++i) shards[i] = new CrucibleRecipe(
                "TB.OreDestruction",
                new ItemStack(ConfigItems.itemShard, TBConfig.shardsFromOre, i),
                new ItemStack(ConfigBlocks.blockCustomOre, 1, 1 + i),
                new AspectList().add(Aspect.ENTROPY, 2)
                    .add(Aspect.MAGIC, 1)
                    .add(getPrimalForLoop(i), 3));
        }
        CrucibleRecipe[] cBlocks = new CrucibleRecipe[7];

        for (int i = 0; i < 7; ++i) if (i < 6) cBlocks[i] = new CrucibleRecipe(
            "TB.CrystalBlocks",
            new ItemStack(TBBlocks.crystalBlock, 1, i),
            new ItemStack(ConfigBlocks.blockCrystal, 1, i),
            new AspectList().add(primals(1))
                .add(Aspect.CRAFT, 2)
                .add(getPrimalForLoop(i), 2));
        else cBlocks[i] = new CrucibleRecipe(
            "TB.CrystalBlocks",
            new ItemStack(TBBlocks.crystalBlock, 1, i),
            new ItemStack(ConfigBlocks.blockCrystal, 1, i),
            new AspectList().add(primals(1))
                .add(Aspect.CRAFT, 2)
                .add(primals(1)));

        CrucibleRecipe[] cTaintedBlocks = new CrucibleRecipe[7];

        for (int i = 0; i < 7; ++i) if (i < 6) cTaintedBlocks[i] = new CrucibleRecipe(
            "TB.CrystalBlocks",
            new ItemStack(TBBlocks.crystalBlock, 1, 7),
            new ItemStack(ConfigBlocks.blockCrystal, 1, i),
            new AspectList().add(primals(1))
                .add(Aspect.CRAFT, 2)
                .add(getPrimalForLoop(i), 2)
                .add(Aspect.TAINT, 2));
        else cTaintedBlocks[i] = new CrucibleRecipe(
            "TB.CrystalBlocks",
            new ItemStack(TBBlocks.crystalBlock, 1, 7),
            new ItemStack(ConfigBlocks.blockCrystal, 1, i),
            new AspectList().add(primals(1))
                .add(Aspect.CRAFT, 2)
                .add(primals(1))
                .add(Aspect.TAINT, 2));

        InfusionRecipe voidRodRecipe = new InfusionRecipe(
            "ROD_tbvoid",
            new ItemStack(TBItems.resource, 1, 4),
            6,
            new AspectList().add(Aspect.ELDRITCH, 64)
                .add(Aspect.VOID, 64)
                .add(Aspect.MAGIC, 64)
                .add(Aspect.AURA, 24)
                .add(Aspect.ENERGY, 24),
            new ItemStack(TBItems.resource, 1, 3),
            new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 16),
                new ItemStack(ConfigItems.itemResource, 1, 16), new ItemStack(ConfigItems.itemResource, 1, 16),
                new ItemStack(ConfigItems.itemResource, 1, 16), new ItemStack(TBBlocks.dustBlock, 1, 0),
                new ItemStack(TBBlocks.dustBlock, 1, 0), new ItemStack(TBBlocks.crystalBlock, 1, 7),
                new ItemStack(TBBlocks.crystalBlock, 1, 7) });

        InfusionRecipe drainFociRec = new InfusionRecipe(
            "TB.Foci.Drain",
            new ItemStack(TBItems.fociDrain),
            0,
            new AspectList().add(Aspect.WATER, 3)
                .add(Aspect.VOID, 6),
            new ItemStack(ConfigItems.itemFocusExcavation, 1, 0),
            new ItemStack[] { new ItemStack(Items.bucket), new ItemStack(Items.bucket),
                new ItemStack(ConfigBlocks.blockJar, 1, 3), new ItemStack(ConfigBlocks.blockJar, 1, 3) });

        InfusionRecipe expFociRec = new InfusionRecipe(
            "TB.Foci.Experience",
            new ItemStack(TBItems.fociExperience),
            5,
            new AspectList().add(Aspect.GREED, 32)
                .add(Aspect.VOID, 32)
                .add(Aspect.MIND, 16)
                .add(Aspect.HUNGER, 32)
                .add(Aspect.MINE, 8),
            new ItemStack(ConfigItems.itemFocusExcavation, 1, 0),
            new ItemStack[] { new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot),
                new ItemStack(Items.emerald), new ItemStack(Items.emerald),
                new ItemStack(Items.iron_axe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Items.iron_pickaxe, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Items.iron_shovel, 1, OreDictionary.WILDCARD_VALUE),
                new ItemStack(Items.shears, 1, OreDictionary.WILDCARD_VALUE) });

        InfusionRecipe fluxFociRec = new InfusionRecipe(
            "TB.Foci.Flux",
            new ItemStack(TBItems.fociFlux),
            3,
            new AspectList().add(Aspect.WATER, 16)
                .add(Aspect.VOID, 16)
                .add(Aspect.ORDER, 16),
            new ItemStack(Items.diamond, 1, 0),
            new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemShard, 1, 6),
                new ItemStack(ConfigBlocks.blockStoneDevice, 1, 14), new ItemStack(ConfigBlocks.blockJar, 1, 3) });

        InfusionRecipe activationFociRec = new InfusionRecipe(
            "TB.Foci.Activation",
            new ItemStack(TBItems.fociActivation),
            0,
            new AspectList().add(Aspect.TRAVEL, 8)
                .add(Aspect.SENSES, 8)
                .add(Aspect.MOTION, 8),
            new ItemStack(ConfigItems.itemResource, 1, 10),
            new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 9),
                new ItemStack(ConfigItems.itemResource, 1, 9), new ItemStack(ConfigItems.itemResource, 1, 14),
                new ItemStack(ConfigItems.itemResource, 1, 14) });

        Block[] recBlocks = new Block[] { Blocks.cobblestone, Blocks.gravel, Blocks.mossy_cobblestone,
            Blocks.iron_block, Blocks.diamond_block, Blocks.lapis_block, Blocks.gold_block, Blocks.brick_block };

        Block[] recResult = new Block[] { TBBlocks.oldCobble, TBBlocks.oldGravel, TBBlocks.oldCobbleMossy,
            TBBlocks.oldIron, TBBlocks.oldDiamond, TBBlocks.oldLapis, TBBlocks.oldGold, TBBlocks.oldBrick };

        ShapedArcaneRecipe[] oldRec = new ShapedArcaneRecipe[recResult.length];

        for (int i = 0; i < oldRec.length; ++i) oldRec[i] = new ShapedArcaneRecipe(
            "TB.DecoBlocks",
            new ItemStack(recResult[i], 6, 0),
            new AspectList().add(Aspect.ENTROPY, 5),
            new Object[] { "# #", "# #", "# #", '#', recBlocks[i] });

        ShapedArcaneRecipe advFurnaceRecipe = new ShapedArcaneRecipe(
            "TB.AdvAlc",
            TBBlocks.advAlchFurnace,
            new AspectList().add(Aspect.WATER, 20)
                .add(Aspect.FIRE, 20)
                .add(Aspect.AIR, 10),
            new Object[] { "# #", "#@#", "$$$", '#', new ItemStack(ConfigItems.itemResource, 1, 2), '@',
                new ItemStack(ConfigBlocks.blockStoneDevice, 1, 0), '$',
                new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 0) });

        InfusionRecipe cryingObsidianRec = new InfusionRecipe(
            "TB.CryingObs",
            new ItemStack(TBBlocks.cryingObsidian, 1, 0),
            2,
            new AspectList().add(Aspect.TRAVEL, 16)
                .add(Aspect.LIFE, 16)
                .add(Aspect.SOUL, 16),
            new ItemStack(Blocks.obsidian),
            new ItemStack[] { new ItemStack(Items.diamond), new ItemStack(Items.bed), new ItemStack(TBBlocks.oldLapis),
                new ItemStack(TBBlocks.oldLapis) });

        InfusionRecipe overchanterRec = new InfusionRecipe(
            "TB.Overchanter",
            new ItemStack(TBBlocks.overchanter, 1, 0),
            4,
            new AspectList().add(primals(32))
                .add(Aspect.MAGIC, 32)
                .add(Aspect.MECHANISM, 32)
                .add(Aspect.MIND, 16),
            new ItemStack(Blocks.enchanting_table),
            new ItemStack[] { new ItemStack(TBBlocks.crystalBlock, 1, 0), new ItemStack(TBBlocks.crystalBlock, 1, 1),
                new ItemStack(TBBlocks.crystalBlock, 1, 2), new ItemStack(TBBlocks.crystalBlock, 1, 3),
                new ItemStack(TBBlocks.crystalBlock, 1, 4), new ItemStack(TBBlocks.crystalBlock, 1, 5),
                new ItemStack(TBBlocks.crystalBlock, 1, 6), new ItemStack(TBBlocks.crystalBlock, 1, 6),
                new ItemStack(TBBlocks.dustBlock, 1, 0), new ItemStack(TBBlocks.dustBlock, 1, 0),
                new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 4),
                new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 4) });

        InfusionRecipe herobrinesScytheRec = new InfusionRecipe("TB.HerobrinesScythe",new ItemStack(TBItems.herobrinesScythe,1,0),7,new AspectList().add(Aspect.WEAPON, 128).add(Aspect.ENERGY, 64).add(Aspect.AURA, 12).add(Aspect.ELDRITCH, 32).add(Aspect.DEATH, 64),new ItemStack(ConfigItems.itemHoeVoid),new ItemStack[]{
            new ItemStack(Items.nether_star),
            new ItemStack(ConfigItems.itemBucketDeath),
            new ItemStack(ConfigItems.itemWandRod,1,100),
            new ItemStack(ConfigItems.itemBucketDeath)
        });

        ShapedArcaneRecipe relocatorRec = new ShapedArcaneRecipe(
            "TB.Relocator",
            new ItemStack(TBBlocks.relocator, 1, 0),
            new AspectList().add(Aspect.AIR, 5)
                .add(Aspect.EARTH, 15)
                .add(Aspect.WATER, 5),
            new Object[] { "GAG", "ENE", "GWG", 'G', new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 6), 'A',
                "shardAir", 'E', "shardEarth", 'W', "shardWater", 'N', new ItemStack(ConfigItems.itemResource, 1, 1) });

        ShapedArcaneRecipe irelocatorRec = new ShapedArcaneRecipe(
            "TB.Relocator",
            new ItemStack(TBBlocks.relocator, 1, 6),
            new AspectList().add(Aspect.AIR, 5)
                .add(Aspect.EARTH, 15)
                .add(Aspect.WATER, 5),
            new Object[] { "GAG", "ENE", "GWG", 'G', new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 6), 'A',
                "shardAir", 'E', "shardEarth", 'W', "shardWater", 'N', new ItemStack(ConfigItems.itemResource, 1, 0) });

        ShapedArcaneRecipe thaumicAnvilRec = new ShapedArcaneRecipe(
            "TB.ThaumicAnvil",
            new ItemStack(TBBlocks.thaumicAnvil, 1, 0),
            primals(25),
            new Object[] { "###", " $ ", "$$$", '#', new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 4), '$',
                new ItemStack(ConfigItems.itemResource, 1, 2) });

        InfusionRecipe voidAnvilRec = new InfusionRecipe(
            "TB.VoidAnvil",
            new ItemStack(TBBlocks.voidAnvil, 1, 0),
            3,
            new AspectList().add(Aspect.CRAFT, 32)
                .add(Aspect.TOOL, 24)
                .add(Aspect.WEAPON, 24)
                .add(Aspect.ORDER, 48),
            new ItemStack(TBBlocks.thaumicAnvil, 1, OreDictionary.WILDCARD_VALUE),
            new ItemStack[] { new ItemStack(TBBlocks.voidBlock), new ItemStack(TBBlocks.voidBlock),
                new ItemStack(TBBlocks.voidBlock), new ItemStack(TBBlocks.voidBlock),
                new ItemStack(TBBlocks.voidBlock) });

        ShapedArcaneRecipe campfireRec = new ShapedArcaneRecipe(
            "TB.Campfire",
            new ItemStack(TBBlocks.campfire),
            new AspectList().add(Aspect.FIRE, 5)
                .add(Aspect.ENTROPY, 3),
            new Object[] { "SSS", "COC", "GGG", 'S', "stickWood", 'C', "cobblestone", 'O',
                new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 'G', Blocks.gravel });

        ShapedArcaneRecipe brazierRec = new ShapedArcaneRecipe(
            "TB.Brazier",
            new ItemStack(TBBlocks.braizer),
            new AspectList().add(Aspect.FIRE, 5)
                .add(Aspect.ENTROPY, 3),
            new Object[] { "SCS", " V ", "SSS", 'S', new ItemStack(ConfigBlocks.blockSlabStone, 1, 0), 'C',
                new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 'V',
                new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 6) });

        ShapedOreRecipe voidBlockRec = new ShapedOreRecipe(
            new ItemStack(TBBlocks.voidBlock, 1, 0),
            new Object[] { "###", "###", "###", '#', new ItemStack(ConfigItems.itemResource, 1, 16) });

        ShapelessOreRecipe voidIngotRec = new ShapelessOreRecipe(
            new ItemStack(ConfigItems.itemResource, 9, 16),
            new ItemStack(TBBlocks.voidBlock));

        // TODO recipes

        // copy(ResearchCategories.getResearchList("ALCHEMY").research.get("CRUCIBLE"),"TB.CRUCIBLE",catName,0,3).setConcealed().setHidden().registerResearchItem();
        // copy(ResearchCategories.getResearchList("ALCHEMY").research.get("THAUMIUM"),"TB.THAUMIUM",catName,8,0).setConcealed().setHidden().registerResearchItem();
        // copy(ResearchCategories.getResearchList("ALCHEMY").research.get("DISTILESSENTIA"),"TB.DISTILESSENTIA",catName,6,2).setConcealed().setHidden().registerResearchItem();

        // copy(ResearchCategories.getResearchList("ARTIFICE").research.get("INFUSION"),"TB.INFUSION",catName,0,-3).setConcealed().setHidden().registerResearchItem();
        // copy(ResearchCategories.getResearchList("ARTIFICE").research.get("BELLOWS"),"TB.BELLOWS",catName,6,3).setConcealed().setHidden().registerResearchItem();
        // copy(ResearchCategories.getResearchList("ARTIFICE").research.get("LEVITATOR"),"TB.LEVITATOR",catName,6,5).setConcealed().setHidden().registerResearchItem();

        // copy(ResearchCategories.getResearchList("ELDRITCH").research.get("VOIDMETAL"),"TB.VOIDMETAL",catName,15,1).setConcealed().setHidden().registerResearchItem();

        new FakeResearchItem(
            "TB.CRUCIBLE",
            "THAUMICBASES",
            "CRUCIBLE",
            "ALCHEMY",
            0,
            3,
            ResearchCategories.getResearch("CRUCIBLE").icon_item).registerResearchItem();
        new FakeResearchItem(
            "TB.THAUMIUM",
            "THAUMICBASES",
            "THAUMIUM",
            "ALCHEMY",
            8,
            0,
            ResearchCategories.getResearch("THAUMIUM").icon_item).registerResearchItem();
        new FakeResearchItem(
            "TB.DISTILESSENTIA",
            "THAUMICBASES",
            "DISTILESSENTIA",
            "ALCHEMY",
            6,
            2,
            ResearchCategories.getResearch("DISTILESSENTIA").icon_item).registerResearchItem();

        new FakeResearchItem(
            "TB.INFUSION",
            "THAUMICBASES",
            "INFUSION",
            "ARTIFICE",
            0,
            -3,
            ResearchCategories.getResearch("INFUSION").icon_item).registerResearchItem();
        new FakeResearchItem(
            "TB.BELLOWS",
            "THAUMICBASES",
            "BELLOWS",
            "ARTIFICE",
            6,
            3,
            ResearchCategories.getResearch("BELLOWS").icon_item).registerResearchItem();
        new FakeResearchItem(
            "TB.LEVITATOR",
            "THAUMICBASES",
            "LEVITATOR",
            "ARTIFICE",
            6,
            5,
            ResearchCategories.getResearch("LEVITATOR").icon_item).registerResearchItem();

        new FakeResearchItem(
            "TB.VOIDMETAL",
            "THAUMICBASES",
            "VOIDMETAL",
            "ELDRITCH",
            15,
            1,
            ResearchCategories.getResearch("VOIDMETAL").icon_item).registerResearchItem();

        // -2,-18
        // 5,-3

        IRecipe[] slabs = new IRecipe[12];
        slabs = TBRecipes.slabs.toArray(slabs);

        new ResearchItem(
            "TB.DecoBlocks",
            catName,
            new AspectList(),
            0,
            2,
            0,
            new ItemStack(TBBlocks.quicksilverBlock, 1, 0)).setRound()
                .setAutoUnlock()
                .setPages(
                    new ResearchPage("tb.rec.decoBlocks.page.0"),
                    new ResearchPage(TBRecipes.recipes.get("quicksilverBlock")),
                    new ResearchPage(TBRecipes.recipes.get("quicksilver")),
                    new ResearchPage(TBRecipes.recipes.get("quicksilverBrick")),
                    new ResearchPage(TBRecipes.recipes.get("eldritchArk")),
                    new ResearchPage(TBRecipes.recipes.get("ironGreatwood")),
                    new ResearchPage(oldRec),
                    new ResearchPage(slabs))
                .registerResearchItem();

        new ResearchItem(
            "TB.AdvancedEntropy",
            catName,
            new AspectList().add(Aspect.ENTROPY, 3)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.CRAFT, 3),
            -3,
            2,
            1,
            new ItemStack(Items.blaze_powder, 1, 0)).setParents("TB.CRUCIBLE")
                .setPages(
                    new ResearchPage("tb.rec.advEntr.page.0"),
                    new ResearchPage(wool3Rec),
                    new ResearchPage(sandstone3Rec),
                    new ResearchPage(blaze3Rec))
                .registerResearchItem();

        new ResearchItem(
            "TB.AlchemyRestoration",
            catName,
            new AspectList().add(Aspect.ORDER, 3)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.CRAFT, 3),
            -3,
            4,
            1,
            new ItemStack(Blocks.packed_ice, 1, 0)).setParents("TB.CRUCIBLE")
                .setPages(
                    new ResearchPage("tb.rec.alcRest.page.0"),
                    new ResearchPage(chiseledBricks),
                    new ResearchPage(gravel2Cobble),
                    new ResearchPage(icePacking))
                .registerResearchItem();

        new ResearchItem(
            "TB.Pyrofluid",
            catName,
            new AspectList().add(Aspect.FIRE, 16)
                .add(Aspect.MAGIC, 6)
                .add(Aspect.ELDRITCH, 8)
                .add(Aspect.GREED, 6),
            1,
            6,
            4,
            new ItemStack(TBItems.pyroBucket, 1, 0)).setParents("TB.CRUCIBLE")
                .setPages(new ResearchPage("tb.rec.pyrofluid.page.0"), new ResearchPage(pyrofluidRec))
                .registerResearchItem();

        new ResearchItem(
            "TB.CrystalBlocks",
            catName,
            new AspectList().add(primals(8)),
            -4,
            5,
            1,
            new ItemStack(TBBlocks.crystalBlock, 1, OreDictionary.WILDCARD_VALUE)).setParents("TB.AlchemyRestoration")
                .setPages(
                    new ResearchPage("tb.rec.cBlocks.page.0"),
                    new ResearchPage(cBlocks),
                    new ResearchPage(cTaintedBlocks))
                .registerResearchItem();

        new ResearchItem(
            "TB.Backprocessing",
            catName,
            new AspectList().add(Aspect.ORDER, 8)
                .add(Aspect.EXCHANGE, 8)
                .add(Aspect.CRAFT, 8),
            -6,
            3,
            1,
            new ItemStack(Items.reeds, 1, 0)).setParents("TB.AlchemyRestoration", "TB.AdvancedEntropy")
                .setSecondary()
                .setConcealed()
                .setPages(
                    new ResearchPage("tb.rec.backProc.page.0"),
                    new ResearchPage(blazepowderRest),
                    new ResearchPage(boneRest),
                    new ResearchPage(sugarRest),
                    new ResearchPage(cactiRest))
                .registerResearchItem();

        // 0, -3

        new ResearchItem(
            "TB.MasterEntropy",
            catName,
            new AspectList().add(Aspect.ENTROPY, 8)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.GREED, 2),
            -5,
            1,
            3,
            new ItemStack(Items.string, 1, 0)).setParents("TB.AdvancedEntropy")
                .setPages(
                    new ResearchPage("tb.rec.mastEntr.page.0"),
                    new ResearchPage(wool4Rec),
                    new ResearchPage(sandstone4Rec),
                    new ResearchPage(blaze4Rec))
                .registerResearchItem();

        new ResearchItem(
            "TB.StrongEntropy",
            catName,
            new AspectList().add(Aspect.ENTROPY, 2)
                .add(Aspect.WEAPON, 2),
            -1,
            1,
            3,
            new ItemStack(Blocks.sand, 1, 0)).setParents("TB.AdvancedEntropy")
                .setSecondary()
                .setPages(
                    new ResearchPage("tb.rec.strEntr.page.0"),
                    new ResearchPage(glassSand),
                    new ResearchPage(gravelSand),
                    new ResearchPage(barsIron))
                .registerResearchItem();

        new ResearchItem(
            "TB.SimpleDublication",
            catName,
            new AspectList().add(Aspect.EXCHANGE, 6)
                .add(Aspect.ORDER, 6),
            3,
            5,
            1,
            new ItemStack(Items.arrow, 1, 0)).setParents("TB.CRUCIBLE")
                .setSecondary()
                .setPages(
                    new ResearchPage("tb.rec.simDup.page.0"),
                    new ResearchPage(arrows),
                    new ResearchPage(snowball),
                    new ResearchPage(redstone))
                .registerResearchItem();

        new ResearchItem(
            "TB.Amber",
            catName,
            new AspectList().add(Aspect.TRAP, 6)
                .add(Aspect.ORDER, 6),
            3,
            4,
            1,
            new ItemStack(ConfigItems.itemResource, 1, 6)).setParents("TB.CRUCIBLE")
                .setSecondary()
                .setPages(new ResearchPage("tb.rec.amber.page.0"), new ResearchPage(amber))
                .registerResearchItem();

        new ResearchItem(
            "TB.Quicksilver",
            catName,
            new AspectList().add(Aspect.TREE, 6)
                .add(Aspect.ORDER, 6),
            3,
            2,
            1,
            new ItemStack(ConfigItems.itemResource, 1, 3)).setParents("TB.CRUCIBLE")
                .setSecondary()
                .setPages(new ResearchPage("tb.rec.cinnabar.page.0"), new ResearchPage(cinnabar))
                .registerResearchItem();

        new ResearchItem(
            "TB.Thauminite",
            catName,
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.CRYSTAL, 8)
                .add(Aspect.CRAFT, 2),
            6,
            -1,
            2,
            new ItemStack(TBItems.resource, 1, 1)).setParents("TB.THAUMIUM")
                .setConcealed()
                .setPages(
                    new ResearchPage("tb.rec.thauminite.page.0"),
                    new ResearchPage(thauminiteRec),
                    new ResearchPage(TBRecipes.recipes.get("thauminiteIngot")),
                    new ResearchPage(TBRecipes.recipes.get("thauminiteNugget")),
                    new ResearchPage(TBRecipes.recipes.get("thauminiteBlock")),
                    new ResearchPage(toolsRec))
                .registerResearchItem();

        new ResearchItem(
            "ROD_tbthaumium",
            catName,
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.AURA, 4)
                .add(Aspect.CRAFT, 2)
                .add(Aspect.MAN, 6),
            10,
            -1,
            2,
            new ItemStack(TBItems.resource, 1, 3)).setParents("TB.THAUMIUM")
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.thaumRod.page.0"), new ResearchPage(thaumicWandCore))
                .registerResearchItem();

        new ResearchItem(
            "ROD_tbvoid",
            catName,
            new AspectList().add(Aspect.ELDRITCH, 4)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.AURA, 4)
                .add(Aspect.VOID, 2)
                .add(Aspect.MIND, 6),
            13,
            -1,
            4,
            new ItemStack(TBItems.resource, 1, 4)).setParents("ROD_tbthaumium", "TB.VOIDMETAL")
                .setConcealed()
                .setSpecial()
                .setPages(new ResearchPage("tb.rec.voidRod.page.0"), new ResearchPage(voidRodRecipe))
                .registerResearchItem();

        new ResearchItem(
            "CAP_thauminite",
            catName,
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.AURA, 4),
            5,
            0,
            2,
            new ItemStack(TBItems.resource, 1, 2)).setParents("TB.Thauminite")
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.capthauminite.page.0"), new ResearchPage(thauminiteCaps))
                .registerResearchItem();

        new ResearchItem(
            "TB.SM",
            catName,
            new AspectList().add(primals(4)),
            3,
            3,
            1,
            new ItemStack(ConfigItems.itemResource, 1, 14)).setParents("TB.CRUCIBLE", "TB.Quicksilver", "TB.Amber")
                .setSecondary()
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.sm.page.0"), new ResearchPage(salisMundis))
                .registerResearchItem();

        new ResearchItem(
            "TB.SMB",
            catName,
            new AspectList().add(primals(6))
                .add(Aspect.CRAFT, 2),
            4,
            3,
            1,
            new ItemStack(TBBlocks.dustBlock)).setParents("TB.SM")
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.smb.page.0"), new ResearchPage(salisMundusBlockRec))
                .registerResearchItem();

        new ResearchItem(
            "TB.OreDestruction",
            catName,
            new AspectList().add(Aspect.ENTROPY, 8)
                .add(Aspect.MAGIC, 4)
                .add(Aspect.ORDER, 1)
                .add(Aspect.FIRE, 1)
                .add(Aspect.AIR, 1)
                .add(Aspect.EARTH, 1)
                .add(Aspect.WATER, 1),
            -7,
            1,
            3,
            new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE)).setParents("TB.MasterEntropy")
                .setPages(new ResearchPage("tb.rec.oreDestr.page.0"), new ResearchPage(shards))
                .registerResearchItem();

        // copy(ResearchCategories.getResearchList("ARTIFICE").research.get("INFUSIONENCHANTMENT"),
        // "TB.INFUSIONENCHANTMENT", catName, 0, 8).setHidden().registerResearchItem();

        new FakeResearchItem(
            "TB.INFUSIONENCHANTMENT",
            "THAUMICBASES",
            "INFUSIONENCHANTMENT",
            "ARTIFICE",
            0,
            8,
            ResearchCategories.getResearch("INFUSIONENCHANTMENT").icon_resource).registerResearchItem();

        new ResearchItem(
            "TB.ElderKnowledge",
            catName,
            new AspectList().add(Aspect.MAGIC, 8)
                .add(Aspect.MIND, 8)
                .add(Aspect.WEAPON, 8),
            -2,
            8,
            1,
            new ResourceLocation("thaumicbases", "textures/enchantments/elder_knowledge.png"))
                .setParents("TB.INFUSIONENCHANTMENT")
                .setSecondary()
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.enchantments.ewisdom"), new ResearchPage(elderKnowledgeEnch))
                .registerResearchItem();

        new ResearchItem(
            "TB.EldritchBane",
            catName,
            new AspectList().add(Aspect.DEATH, 8)
                .add(Aspect.ELDRITCH, 8)
                .add(Aspect.WEAPON, 8),
            -1,
            10,
            1,
            new ResourceLocation("thaumicbases", "textures/enchantments/eldritch_bane.png"))
                .setParents("TB.INFUSIONENCHANTMENT")
                .setSecondary()
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.enchantments.ebane"), new ResearchPage(elderBaneEnch))
                .registerResearchItem();

        new ResearchItem(
            "TB.MagicTouch",
            catName,
            new AspectList().add(Aspect.MAGIC, 8)
                .add(Aspect.AURA, 8)
                .add(Aspect.WEAPON, 8),
            -1,
            6,
            1,
            new ResourceLocation("thaumicbases", "textures/enchantments/magic_touched.png"))
                .setParents("TB.INFUSIONENCHANTMENT")
                .setSecondary()
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.enchantments.magictouched"), new ResearchPage(magicTouchEnch))
                .registerResearchItem();

        new ResearchItem(
            "TB.Vaporising",
            catName,
            new AspectList().add(Aspect.MAGIC, 8)
                .add(Aspect.CRYSTAL, 8)
                .add(Aspect.TRAP, 8),
            -3,
            7,
            1,
            new ResourceLocation("thaumicbases", "textures/enchantments/vaporising.png"))
                .setParents("TB.INFUSIONENCHANTMENT")
                .setSecondary()
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.enchantments.vaporising"), new ResearchPage(vaporisingEnch))
                .registerResearchItem();

        new ResearchItem(
            "TB.Tainted",
            catName,
            new AspectList().add(Aspect.TAINT, 16),
            -3,
            9,
            1,
            new ResourceLocation("thaumicbases", "textures/enchantments/tainted.png"))
                .setParents("TB.INFUSIONENCHANTMENT")
                .setSecondary()
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.enchantments.taint"), new ResearchPage(taintedEnch))
                .registerResearchItem();

        new ResearchItem(
            "TB.Foci.Drain",
            catName,
            new AspectList().add(Aspect.WATER, 6)
                .add(Aspect.VOID, 3),
            -3,
            -2,
            0,
            new ItemStack(TBItems.fociDrain)).setParents("TB.INFUSION")
                .setParentsHidden("FOCUSEXCAVATION", "JARVOID")
                .setConcealed()
                .setSecondary()
                .setPages(
                    new ResearchPage("tb.rec.drainFoci.page.0"),
                    new ResearchPage(drainFociRec),
                    new ResearchPage("tb.rec.drainFoci.page.1"),
                    new ResearchPage("tb.rec.drainFoci.page.2"))
                .registerResearchItem();

        new ResearchItem(
            "TB.Foci.Experience",
            catName,
            new AspectList().add(Aspect.GREED, 16)
                .add(Aspect.HUNGER, 16)
                .add(Aspect.MINE, 2)
                .add(Aspect.MIND, 8),
            -2,
            -5,
            1,
            new ItemStack(TBItems.fociExperience)).setParents("TB.INFUSION")
                .setParentsHidden("FOCUSEXCAVATION")
                .setConcealed()
                .setPages(
                    new ResearchPage("tb.rec.expFoci.page.0"),
                    new ResearchPage(expFociRec),
                    new ResearchPage("tb.rec.expFoci.page.1"),
                    new ResearchPage("tb.rec.expFoci.page.2"))
                .registerResearchItem();

        new ResearchItem(
            "TB.Foci.Flux",
            catName,
            new AspectList().add(Aspect.WATER, 4)
                .add(Aspect.ORDER, 4)
                .add(Aspect.VOID, 4),
            -2,
            -1,
            0,
            new ItemStack(TBItems.fociFlux)).setParents("TB.INFUSION")
                .setParentsHidden("JARVOID", "FLUXSCRUB")
                .setConcealed()
                .setSecondary()
                .setPages(
                    new ResearchPage("tb.rec.fluxFoci.page.0"),
                    new ResearchPage(fluxFociRec),
                    new ResearchPage("tb.rec.fluxFoci.page.1"),
                    new ResearchPage("tb.rec.fluxFoci.page.2"),
                    new ResearchPage("tb.rec.fluxFoci.page.3"))
                .registerResearchItem();

        new ResearchItem(
            "TB.Foci.Activation",
            catName,
            new AspectList().add(Aspect.TRAVEL, 4)
                .add(Aspect.MOTION, 4)
                .add(Aspect.SENSES, 4),
            -3,
            -4,
            0,
            new ItemStack(TBItems.fociActivation)).setParents("TB.INFUSION")
                .setParentsHidden("MIRRORHAND")
                .setConcealed()
                .setSecondary()
                .setPages(
                    new ResearchPage("tb.rec.actFoci.page.0"),
                    new ResearchPage(activationFociRec),
                    new ResearchPage("tb.rec.actFoci.page.1"))
                .registerResearchItem();

        new ResearchItem(
            "TB.AdvAlc",
            catName,
            new AspectList().add(Aspect.MOTION, 16)
                .add(Aspect.AIR, 16)
                .add(Aspect.FIRE, 8)
                .add(Aspect.CRAFT, 4),
            8,
            2,
            2,
            new ItemStack(TBBlocks.advAlchFurnace)).setParents("TB.THAUMIUM", "TB.DISTILESSENTIA", "TB.BELLOWS")
                .setPages(new ResearchPage("tb.rec.advAlc.page.0"), new ResearchPage(advFurnaceRecipe))
                .registerResearchItem();

        new ResearchItem(
            "TB.CryingObs",
            catName,
            new AspectList().add(Aspect.TRAVEL, 8)
                .add(Aspect.LIFE, 8)
                .add(Aspect.SOUL, 8),
            3,
            -4,
            2,
            new ItemStack(TBBlocks.cryingObsidian, 1, 0)).setParents("TB.INFUSION")
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.cryingObs.page.0"), new ResearchPage(cryingObsidianRec))
                .registerResearchItem();

        new ResearchItem(
            "TB.Overchanter",
            catName,
            new AspectList().add(primals(8))
                .add(Aspect.MIND, 8)
                .add(Aspect.MAGIC, 8),
            -5,
            -3,
            3,
            new ItemStack(TBBlocks.overchanter, 1, 0)).setParents("TB.INFUSION")
                .setConcealed()
                .setPages(
                    new ResearchPage("tb.rec.overchanter.page.0"),
                    new ResearchPage("tb.rec.overchanter.page.1"),
                    new ResearchPage("tb.rec.overchanter.page.2"),
                    new ResearchPage(overchanterRec))
                .registerResearchItem();

        new ResearchItem("TB.HerobrinesScythe",catName,new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.DEATH, 16).add(Aspect.WEAPON, 16).add(Aspect.AURA, 8).add(Aspect.ENERGY, 6),15,1,4,new ItemStack(TBItems.herobrinesScythe,1,0))
        .setParents("TB.VOIDMETAL")
        .setConcealed()
        .setSpecial()
        .setPages(
            new ResearchPage("tb.rec.hScythe.page.0"),
            new ResearchPage("tb.rec.hScythe.page.1"),
            new ResearchPage(herobrinesScytheRec)
            ).registerResearchItem();

        new ResearchItem(
            "TB.Relocator",
            catName,
            new AspectList().add(Aspect.MOTION, 4)
                .add(Aspect.AIR, 4)
                .add(Aspect.VOID, 4),
            6,
            7,
            1,
            new ItemStack(TBBlocks.relocator, 1, 0)).setParents("TB.LEVITATOR")
                .setConcealed()
                .setPages(
                    new ResearchPage("tb.rec.relocator.page.0"),
                    new ResearchPage(relocatorRec),
                    new ResearchPage(irelocatorRec))
                .registerResearchItem();

        new ResearchItem(
            "TB.ThaumicAnvil",
            catName,
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.CRAFT, 3),
            10,
            2,
            2,
            new ItemStack(TBBlocks.thaumicAnvil, 1, 0)).setParents("TB.THAUMIUM")
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.thaumicAnvil.page.0"), new ResearchPage(thaumicAnvilRec))
                .registerResearchItem();

        new ResearchItem(
            "TB.VoidAnvil",
            catName,
            new AspectList().add(Aspect.METAL, 4)
                .add(Aspect.CRAFT, 3)
                .add(Aspect.TOOL, 4)
                .add(Aspect.ELDRITCH, 4),
            13,
            2,
            2,
            new ItemStack(TBBlocks.voidAnvil, 1, 0)).setParents("TB.VOIDMETAL", "TB.ThaumicAnvil")
                .setConcealed()
                .setPages(
                    new ResearchPage("tb.rec.voidAnvil.page.0"),
                    new ResearchPage("tb.rec.voidAnvil.page.1"),
                    new ResearchPage(voidAnvilRec))
                .registerResearchItem();

        new ResearchItem(
            "TB.Campfire",
            catName,
            new AspectList().add(Aspect.FIRE, 3)
                .add(Aspect.MIND, 3)
                .add(Aspect.ENTROPY, 3),
            9,
            5,
            1,
            new ItemStack(TBBlocks.campfire, 1, 0)).setRound()
                .setPages(new ResearchPage("tb.rec.campfire.page.0"), new ResearchPage(campfireRec))
                .registerResearchItem();

        new ResearchItem(
            "TB.Brazier",
            catName,
            new AspectList().add(Aspect.FIRE, 3)
                .add(Aspect.MIND, 3)
                .add(Aspect.ENTROPY, 3)
                .add(Aspect.MAGIC, 3)
                .add(Aspect.MOTION, 3),
            9,
            7,
            0,
            new ItemStack(TBBlocks.braizer, 1, 0)).setParents("TB.Campfire")
                .setSecondary()
                .setPages(new ResearchPage("tb.rec.brazier.page.0"), new ResearchPage(brazierRec))
                .registerResearchItem();

        // TODO last recipes
        // -4,-14

        // Add warp to research
        ThaumcraftApi.addWarpToResearch("TB.HerobrinesScythe", 4);
        // ench
        ThaumcraftApi.addWarpToResearch("TB.Tainted", 3);

        ThaumcraftApi.addWarpToResearch("TB.CryingObs", 1);
        ThaumcraftApi.addWarpToResearch("TB.EntityDec", 2);
        ThaumcraftApi.addWarpToResearch("TB.VoidAnvil", 2);

        // Add new crudible recips
        ThaumcraftApi.getCraftingRecipes()
            .add(wool3Rec);
        ThaumcraftApi.getCraftingRecipes()
            .add(sandstone3Rec);
        ThaumcraftApi.getCraftingRecipes()
            .add(blaze3Rec);
        ThaumcraftApi.getCraftingRecipes()
            .add(wool4Rec);
        ThaumcraftApi.getCraftingRecipes()
            .add(sandstone4Rec);
        ThaumcraftApi.getCraftingRecipes()
            .add(blaze4Rec);
        ThaumcraftApi.getCraftingRecipes()
            .add(glassSand);
        ThaumcraftApi.getCraftingRecipes()
            .add(gravelSand);
        ThaumcraftApi.getCraftingRecipes()
            .add(barsIron);
        ThaumcraftApi.getCraftingRecipes()
            .add(arrows);
        ThaumcraftApi.getCraftingRecipes()
            .add(snowball);
        ThaumcraftApi.getCraftingRecipes()
            .add(redstone);
        ThaumcraftApi.getCraftingRecipes()
            .add(amber);

        // Infusion enchants
        ThaumcraftApi.getCraftingRecipes()
            .add(elderKnowledgeEnch);
        ThaumcraftApi.getCraftingRecipes()
            .add(elderBaneEnch);
        ThaumcraftApi.getCraftingRecipes()
            .add(magicTouchEnch);
        ThaumcraftApi.getCraftingRecipes()
            .add(vaporisingEnch);
        ThaumcraftApi.getCraftingRecipes()
            .add(taintedEnch);

        //
        ThaumcraftApi.getCraftingRecipes()
            .add(cinnabar);
        ThaumcraftApi.getCraftingRecipes()
            .add(salisMundis);
        ThaumcraftApi.getCraftingRecipes()
            .add(chiseledBricks);
        ThaumcraftApi.getCraftingRecipes()
            .add(gravel2Cobble);
        ThaumcraftApi.getCraftingRecipes()
            .add(icePacking);
        ThaumcraftApi.getCraftingRecipes()
            .add(blazepowderRest);
        ThaumcraftApi.getCraftingRecipes()
            .add(boneRest);
        ThaumcraftApi.getCraftingRecipes()
            .add(sugarRest);
        ThaumcraftApi.getCraftingRecipes()
            .add(cactiRest);

        ThaumcraftApi.getCraftingRecipes()
            .add(salisMundusBlockRec);

        ThaumcraftApi.getCraftingRecipes()
            .add(thauminiteRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(thauminiteCaps);

        ThaumcraftApi.getCraftingRecipes()
            .add(pyrofluidRec);

        ThaumcraftApi.getCraftingRecipes()
            .add(thaumicWandCore);
        ThaumcraftApi.getCraftingRecipes()
            .add(voidRodRecipe);

        // TODO Tobacco
        if (TBConfig.allowTobacco) {

            ThaumcraftApi.addWarpToResearch("TB.Tobacco.Eldritch", 2);
            ThaumcraftApi.addWarpToResearch("TB.Tobacco.Tainted", 3);

            ThaumcraftApi.addWarpToItem(new ItemStack(TBItems.tobacco, 1, 1), 1);

            ShapelessArcaneRecipe saturatingTobaccoRec = new ShapelessArcaneRecipe(
                "TB.Tobacco.Saturating",
                new ItemStack(TBItems.tobacco, 1, 3),
                new AspectList().add(Aspect.EARTH, 10)
                    .add(Aspect.FIRE, 10)
                    .add(Aspect.WATER, 10),
                new Object[] { new ItemStack(TBItems.tobacco, 1, 0), new ItemStack(Items.pumpkin_seeds) });
            ShapelessArcaneRecipe saturatingTobaccoRecM = new ShapelessArcaneRecipe(
                "TB.Tobacco.Saturating",
                new ItemStack(TBItems.tobacco, 1, 3),
                new AspectList().add(Aspect.EARTH, 10)
                    .add(Aspect.FIRE, 10)
                    .add(Aspect.WATER, 10),
                new Object[] { new ItemStack(TBItems.tobacco, 1, 0), new ItemStack(Items.melon_seeds) });

            // Seeds
            CrucibleRecipe tobaccoSeedRec = new CrucibleRecipe(
                "TB.Tobacco",
                new ItemStack(TBItems.tobaccoSeeds, 1, 0),
                new ItemStack(Items.wheat_seeds, 1, 0),
                new AspectList().add(Aspect.MIND, 4)
                    .add(Aspect.WATER, 4)
                    .add(Aspect.MAN, 4)
                    .add(Aspect.CROP, 4));

            // M&P
            ShapelessArcaneRecipe pestleRecipe = new ShapelessArcaneRecipe(
                "TB.Tobacco",
                TBItems.mortar,
                new AspectList().add(primals(4)),
                new Object[] { new ItemStack(Items.bowl), new ItemStack(Items.stick), new ItemStack(Blocks.wooden_slab),
                    new ItemStack(Blocks.wooden_slab), new ItemStack(Blocks.wooden_slab) });

            ShapelessArcaneRecipe genTobaccoRec = new ShapelessArcaneRecipe(
                "TB.Tobacco",
                new ItemStack(TBItems.tobacco, 1, 0),
                new AspectList().add(Aspect.ORDER, 1)
                    .add(Aspect.ENTROPY, 1),
                new Object[] { "pestleAndMortar", new ItemStack(TBItems.resource, 1, 7) });

            // GW pipe
            ShapedArcaneRecipe pipeRecipe = new ShapedArcaneRecipe(
                "TB.Tobacco",
                TBItems.greatwoodPipe,
                new AspectList().add(primals(4)),
                new Object[] { "#@ ", " ##", '#', new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 6), '@',
                    new ItemStack(ConfigItems.itemResource, 1, 14) });

            new ResearchItem(
                "TB.Tobacco",
                catName,
                new AspectList().add(Aspect.CROP, 4)
                    .add(Aspect.HARVEST, 4)
                    .add(Aspect.MAN, 4)
                    .add(Aspect.MIND, 4),
                11,
                -7,
                3,
                new ItemStack(TBItems.greatwoodPipe, 1, 0)).setParentsHidden("TB.Plax")
                    .setConcealed()
                    .setPages(
                        new ResearchPage("tb.rec.tobacco.page.0"),
                        new ResearchPage(tobaccoSeedRec),
                        new ResearchPage("tb.rec.tobacco.page.1"),
                        new ResearchPage(pipeRecipe),
                        new ResearchPage(pestleRecipe),
                        new ResearchPage(genTobaccoRec),
                        new ResearchPage("tb.rec.tobacco.page.2"))
                    .registerResearchItem();

            // SW Pipe
            InfusionRecipe silverwoodPipeRec = new InfusionRecipe(
                "TB.SilverwoodPipe",
                new ItemStack(TBItems.silverwoodPipe, 1, 0),
                4,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.ORDER, 32)
                    .add(Aspect.HEAL, 16),
                new ItemStack(TBItems.greatwoodPipe, 1, 0),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 7),
                    new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 7),
                    new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 7),
                    new ItemStack(ConfigBlocks.blockWoodenDevice, 1, 7),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 2) });

            new ResearchItem(
                "TB.SilverwoodPipe",
                catName,
                new AspectList().add(Aspect.ORDER, 8)
                    .add(Aspect.HEAL, 8)
                    .add(Aspect.AURA, 8),
                13,
                -9,
                1,
                new ItemStack(TBItems.silverwoodPipe, 1, 0)).setParents("TB.Tobacco")
                    .setParentsHidden("TB.INFUSION")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.silverPipe.page.0"), new ResearchPage(silverwoodPipeRec))
                    .registerResearchItem();

            //

            InfusionRecipe eldritchTobacoRec = new InfusionRecipe(
                "TB.Tobacco.Eldritch",
                new ItemStack(TBItems.tobacco, 1, 1),
                1,
                new AspectList().add(Aspect.ELDRITCH, 4)
                    .add(Aspect.DEATH, 1),
                new ItemStack(TBItems.tobacco, 1, 0),
                new ItemStack[] { new ItemStack(Items.ender_eye, 1, 0), new ItemStack(Items.arrow, 1, 0) });

            InfusionRecipe wispyTobaccoRec = new InfusionRecipe(
                "TB.Tobacco.Wispy",
                new ItemStack(TBItems.tobacco, 1, 8),
                1,
                new AspectList().add(Aspect.AURA, 4)
                    .add(Aspect.MAGIC, 6),
                new ItemStack(TBItems.tobacco, 1, 0),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigItems.itemCrystalEssence, 1, OreDictionary.WILDCARD_VALUE) });

            CrucibleRecipe angryTobaccoRec = new CrucibleRecipe(
                "TB.Tobacco.Angry",
                new ItemStack(TBItems.tobacco, 1, 2),
                new ItemStack(TBItems.tobacco, 1, 0),
                new AspectList().add(Aspect.WEAPON, 4)
                    .add(Aspect.HUNGER, 4));
            CrucibleRecipe miningTobaccoRec = new CrucibleRecipe(
                "TB.Tobacco.Mining",
                new ItemStack(TBItems.tobacco, 1, 5),
                new ItemStack(TBItems.tobacco, 1, 0),
                new AspectList().add(Aspect.MINE, 4)
                    .add(Aspect.MOTION, 4));
            CrucibleRecipe wisdomTobaccoRec = new CrucibleRecipe(
                "TB.Tobacco.Wisdom",
                new ItemStack(TBItems.tobacco, 1, 4),
                new ItemStack(TBItems.tobacco, 1, 0),
                new AspectList().add(Aspect.MIND, 4)
                    .add(Aspect.AIR, 4));
            CrucibleRecipe taintTobaccoRec = new CrucibleRecipe(
                "TB.Tobacco.Tainted",
                new ItemStack(TBItems.tobacco, 1, 7),
                new ItemStack(TBItems.tobacco, 1, 0),
                new AspectList().add(Aspect.TAINT, 4)
                    .add(Aspect.MIND, 4));
            ShapelessArcaneRecipe sanityTobaccoRec = new ShapelessArcaneRecipe(
                "TB.Tobacco.Sanity",
                new ItemStack(TBItems.tobacco, 1, 6),
                new AspectList().add(Aspect.ORDER, 10)
                    .add(Aspect.AIR, 10)
                    .add(Aspect.ENTROPY, 10),
                new Object[] { new ItemStack(TBItems.tobacco, 1, 0) });

            new ResearchItem(
                "TB.Tobacco.Eldritch",
                catName,
                new AspectList().add(Aspect.DEATH, 4)
                    .add(Aspect.ELDRITCH, 4),
                14,
                -7,
                0,
                new ItemStack(TBItems.tobacco, 1, 1)).setParents("TB.Tobacco")
                    .setParentsHidden("TB.INFUSION")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.etobacco.page.0"), new ResearchPage(eldritchTobacoRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Tobacco.Wispy",
                catName,
                new AspectList().add(Aspect.AURA, 4)
                    .add(Aspect.MAGIC, 4),
                15,
                -9,
                0,
                new ItemStack(TBItems.tobacco, 1, 8)).setParents("TB.Tobacco")
                    .setParentsHidden("TB.INFUSION")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.wtobacco.page.0"), new ResearchPage(wispyTobaccoRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Tobacco.Angry",
                catName,
                new AspectList().add(Aspect.WEAPON, 4)
                    .add(Aspect.HUNGER, 4),
                11,
                -9,
                0,
                new ItemStack(TBItems.tobacco, 1, 2)).setParents("TB.Tobacco")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.atobacco.page.0"), new ResearchPage(angryTobaccoRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Tobacco.Mining",
                catName,
                new AspectList().add(Aspect.MINE, 4)
                    .add(Aspect.MOTION, 4),
                8,
                -7,
                0,
                new ItemStack(TBItems.tobacco, 1, 5)).setParents("TB.Tobacco")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.mtobacco.page.0"), new ResearchPage(miningTobaccoRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Tobacco.Wisdom",
                catName,
                new AspectList().add(Aspect.MIND, 4)
                    .add(Aspect.AIR, 4),
                13,
                -6,
                0,
                new ItemStack(TBItems.tobacco, 1, 4)).setParents("TB.Tobacco")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.witobacco.page.0"), new ResearchPage(wisdomTobaccoRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Tobacco.Tainted",
                catName,
                new AspectList().add(Aspect.MIND, 4)
                    .add(Aspect.TAINT, 4),
                15,
                -8,
                0,
                new ItemStack(TBItems.tobacco, 1, 7)).setParents("TB.Tobacco")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.ttobacco.page.0"), new ResearchPage(taintTobaccoRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Tobacco.Saturating",
                catName,
                new AspectList().add(Aspect.FLESH, 4)
                    .add(Aspect.HUNGER, 4),
                10,
                -9,
                0,
                new ItemStack(TBItems.tobacco, 1, 3)).setParents("TB.Tobacco")
                    .setConcealed()
                    .setSecondary()
                    .setPages(
                        new ResearchPage("tb.rec.stobacco.page.0"),
                        new ResearchPage(new ShapelessArcaneRecipe[] { saturatingTobaccoRec, saturatingTobaccoRecM }))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Tobacco.Sanity",
                catName,
                new AspectList().add(Aspect.ORDER, 4)
                    .add(Aspect.MIND, 4),
                9,
                -8,
                0,
                new ItemStack(TBItems.tobacco, 1, 6)).setParents("TB.Tobacco")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.satobacco.page.0"), new ResearchPage(sanityTobaccoRec))
                    .registerResearchItem();

            ThaumcraftApi.getCraftingRecipes()
                .add(tobaccoSeedRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(pestleRecipe);
            ThaumcraftApi.getCraftingRecipes()
                .add(pipeRecipe);
            ThaumcraftApi.getCraftingRecipes()
                .add(genTobaccoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(eldritchTobacoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(wispyTobaccoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(angryTobaccoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(miningTobaccoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(wisdomTobaccoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(taintTobaccoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(saturatingTobaccoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(saturatingTobaccoRecM);
            ThaumcraftApi.getCraftingRecipes()
                .add(sanityTobaccoRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(silverwoodPipeRec);
        }

        // TODO BloodyMess
        if (TBConfig.enableBloodyMess) {

            // copy(ResearchCategories.getResearchList("ARTIFICE").research.get("ENCHFABRIC"),"TB.ENCHFABRIC",catName,8,-3).setConcealed().setHidden().registerResearchItem();

            new FakeResearchItem(
                "TB.ENCHFABRIC",
                "THAUMICBASES",
                "ENCHFABRIC",
                "ARTIFICE",
                8,
                -3,
                ResearchCategories.getResearch("ENCHFABRIC").icon_item).registerResearchItem();

            ThaumcraftApi.addWarpToResearch("TB.BloodyRobes", 2);

            ShapedArcaneRecipe bloodyChestRec = new ShapedArcaneRecipe(
                "TB.BloodyRobes",
                new ItemStack(TBItems.bloodyChest, 1, 0),
                new AspectList().add(Aspect.AIR, 5),
                new Object[] { "# #", "###", "###", '#', new ItemStack(TBItems.resource, 1, 8) });

            ShapedArcaneRecipe bloodyLegsRec = new ShapedArcaneRecipe(
                "TB.BloodyRobes",
                new ItemStack(TBItems.bloodyLeggings, 1, 0),
                new AspectList().add(Aspect.WATER, 5),
                new Object[] { "###", "# #", "# #", '#', new ItemStack(TBItems.resource, 1, 8) });

            ShapedArcaneRecipe bloodyBootsRec = new ShapedArcaneRecipe(
                "TB.BloodyRobes",
                new ItemStack(TBItems.bloodyBoots, 1, 0),
                new AspectList().add(Aspect.EARTH, 3),
                new Object[] { "# #", "# #", '#', new ItemStack(TBItems.resource, 1, 8) });

            ShapedArcaneRecipe ironSpikeRec = new ShapedArcaneRecipe(
                "TB.Spike.Iron",
                new ItemStack(TBBlocks.spike, 1, 0),
                new AspectList().add(Aspect.FIRE, 1)
                    .add(Aspect.ENTROPY, 1),
                new Object[] { " * ", "*#*", "#_#", '*', "nuggetIron", '#', "ingotIron", '_',
                    new ItemStack(Blocks.heavy_weighted_pressure_plate, 1, 0) });

            ShapedArcaneRecipe thaumiumSpikeRec = new ShapedArcaneRecipe(
                "TB.Spike.Thaumic",
                new ItemStack(TBBlocks.spike, 1, 2),
                primals(4),
                new Object[] { " * ", "*#*", "#_#", '*', "nuggetThaumium", '#', "ingotThaumium", '_',
                    new ItemStack(TBBlocks.spike, 1, 0) });

            ShapedArcaneRecipe voidSpikeRec = new ShapedArcaneRecipe(
                "TB.Spike.Void",
                new ItemStack(TBBlocks.spike, 1, 4),
                primals(4),
                new Object[] { " * ", "*#*", "#_#", '*', "nuggetVoid", '#', "ingotVoid", '_',
                    new ItemStack(TBBlocks.spike, 1, 2) });

            CrucibleRecipe cleanEFabricRec = new CrucibleRecipe(
                "TB.Spike.Iron",
                new ItemStack(ConfigItems.itemResource, 1, 7),
                new ItemStack(TBItems.resource, 1, 8),
                new AspectList().add(Aspect.ORDER, 1));

            new ResearchItem(
                "TB.Spike.Iron",
                catName,
                new AspectList().add(Aspect.WEAPON, 6)
                    .add(Aspect.HUNGER, 6)
                    .add(Aspect.METAL, 6),
                10,
                -3,
                1,
                new ItemStack(TBBlocks.spike, 1, 0)).setParents("TB.ENCHFABRIC")
                    .setPages(
                        new ResearchPage("tb.rec.spikeIron.page.0"),
                        new ResearchPage(ironSpikeRec),
                        new ResearchPage(cleanEFabricRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Spike.Thaumic",
                catName,
                new AspectList().add(Aspect.WEAPON, 6)
                    .add(Aspect.MAGIC, 6)
                    .add(Aspect.MECHANISM, 6),
                13,
                -3,
                1,
                new ItemStack(TBBlocks.spike, 1, 2)).setConcealed()
                    .setParents("TB.Spike.Iron")
                    .setParentsHidden("TB.THAUMIUM")
                    .setPages(new ResearchPage("tb.rec.spikeThaumic.page.0"), new ResearchPage(thaumiumSpikeRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.BloodyRobes",
                catName,
                new AspectList().add(Aspect.HUNGER, 6)
                    .add(Aspect.FLESH, 6)
                    .add(Aspect.ARMOR, 6),
                12,
                -4,
                1,
                new ItemStack(TBItems.bloodyChest, 1, 0)).setConcealed()
                    .setParents("TB.Spike.Iron")
                    .setPages(
                        new ResearchPage("tb.rec.bloodyRobes.page.0"),
                        new ResearchPage(bloodyChestRec),
                        new ResearchPage(bloodyLegsRec),
                        new ResearchPage(bloodyBootsRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Spike.Void",
                catName,
                new AspectList().add(Aspect.WEAPON, 6)
                    .add(Aspect.ELDRITCH, 6)
                    .add(Aspect.ARMOR, 6),
                15,
                -2,
                2,
                new ItemStack(TBBlocks.spike, 1, 4)).setConcealed()
                    .setParents("TB.Spike.Thaumic")
                    .setParentsHidden("TB.VOIDMETAL")
                    .setPages(new ResearchPage("tb.rec.spikeVoid.page.0"), new ResearchPage(voidSpikeRec))
                    .registerResearchItem();

            ThaumcraftApi.getCraftingRecipes()
                .add(ironSpikeRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(thaumiumSpikeRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(voidSpikeRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(cleanEFabricRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(bloodyChestRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(bloodyLegsRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(bloodyBootsRec);
        }

        // TODO Bracelets
        if (TBConfig.enableBracelets) {

            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("CAP_gold"),"TB.CAP_gold",catName,-8,10).setConcealed().setHidden().registerResearchItem();
            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("ROD_greatwood"),"TB.ROD_greatwood",catName,-10,6).setConcealed().setHidden().registerResearchItem();
            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("ROD_silverwood"),"TB.ROD_silverwood",catName,-12,6).setConcealed().setHidden().registerResearchItem();

            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("ROD_reed"),"TB.ROD_reed",catName,-19,5).setConcealed().setHidden().registerResearchItem();
            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("ROD_blaze"),"TB.ROD_blaze",catName,-15,5).setConcealed().setHidden().registerResearchItem();
            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("ROD_obsidian"),"TB.ROD_obsidian",catName,-19,11).setConcealed().setHidden().registerResearchItem();
            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("ROD_ice"),"TB.ROD_ice",catName,-17,5).setConcealed().setHidden().registerResearchItem();
            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("ROD_quartz"),"TB.ROD_quartz",catName,-17,11).setConcealed().setHidden().registerResearchItem();
            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("ROD_bone"),"TB.ROD_bone",catName,-15,11).setConcealed().setHidden().registerResearchItem();

            // copy(ResearchCategories.getResearchList("ELDRITCH").research.get("ROD_primal_staff"),"TB.ROD_primal_staff",catName,-19,8).setConcealed().setHidden().registerResearchItem();

            new FakeResearchItem(
                "TB.CAP_gold",
                "THAUMICBASES",
                "CAP_gold",
                "THAUMATURGY",
                -8,
                10,
                ResearchCategories.getResearch("CAP_gold").icon_item).registerResearchItem();
            new FakeResearchItem(
                "TB.ROD_greatwood",
                "THAUMICBASES",
                "ROD_greatwood",
                "THAUMATURGY",
                -10,
                6,
                ResearchCategories.getResearch("ROD_greatwood").icon_item).registerResearchItem();
            new FakeResearchItem(
                "TB.ROD_silverwood",
                "THAUMICBASES",
                "ROD_silverwood",
                "THAUMATURGY",
                -12,
                6,
                ResearchCategories.getResearch("ROD_silverwood").icon_item).registerResearchItem();

            new FakeResearchItem(
                "TB.ROD_reed",
                "THAUMICBASES",
                "ROD_reed",
                "THAUMATURGY",
                -19,
                5,
                ResearchCategories.getResearch("ROD_reed").icon_item).registerResearchItem();
            new FakeResearchItem(
                "TB.ROD_blaze",
                "THAUMICBASES",
                "ROD_blaze",
                "THAUMATURGY",
                -15,
                5,
                ResearchCategories.getResearch("ROD_blaze").icon_item).registerResearchItem();
            new FakeResearchItem(
                "TB.ROD_obsidian",
                "THAUMICBASES",
                "ROD_obsidian",
                "THAUMATURGY",
                -19,
                11,
                ResearchCategories.getResearch("ROD_obsidian").icon_item).registerResearchItem();
            new FakeResearchItem(
                "TB.ROD_ice",
                "THAUMICBASES",
                "ROD_ice",
                "THAUMATURGY",
                -17,
                5,
                ResearchCategories.getResearch("ROD_ice").icon_item).registerResearchItem();
            new FakeResearchItem(
                "TB.ROD_quartz",
                "THAUMICBASES",
                "ROD_quartz",
                "THAUMATURGY",
                -17,
                11,
                ResearchCategories.getResearch("ROD_quartz").icon_item).registerResearchItem();
            new FakeResearchItem(
                "TB.ROD_bone",
                "THAUMICBASES",
                "ROD_bone",
                "THAUMATURGY",
                -15,
                11,
                ResearchCategories.getResearch("ROD_bone").icon_item).registerResearchItem();

            new FakeResearchItem(
                "TB.ROD_primal_staff",
                "THAUMICBASES",
                "ROD_primal_staff",
                "THAUMATURGY",
                -19,
                8,
                ResearchCategories.getResearch("ROD_primal_staff").icon_item).registerResearchItem();

            ThaumcraftApi.addWarpToResearch("TB.Bracelet.Void", 2);
            ThaumcraftApi.addWarpToResearch("TB.Bracelet.Bone", 1);
            ThaumcraftApi.addWarpToResearch("TB.Bracelet.Primal", 4);

            ThaumcraftApi.addWarpToItem(new ItemStack(TBItems.castingBracelet, 1, 12), 3);

            ShapedArcaneRecipe ironBraceletRec = new ShapedArcaneRecipe(
                "TB.Bracelet.Iron",
                new ItemStack(TBItems.castingBracelet, 1, 0),
                primals(1),
                new Object[] { "CIC", "N N", 'C', new ItemStack(ConfigItems.itemWandCap, 1, 0), 'I', "ingotIron", 'N',
                    "nuggetIron" });

            ShapedArcaneRecipe goldBraceletRec = new ShapedArcaneRecipe(
                "TB.Bracelet.Gold",
                new ItemStack(TBItems.castingBracelet, 1, 1),
                primals(5),
                new Object[] { "CIC", "N N", 'C', new ItemStack(ConfigItems.itemWandCap, 1, 1), 'I', "ingotGold", 'N',
                    "nuggetGold" });

            ShapedArcaneRecipe greatwoodBraceletRec = new ShapedArcaneRecipe(
                "TB.Bracelet.Greatwood",
                new ItemStack(TBItems.castingBracelet, 1, 2),
                primals(25),
                new Object[] { "CIC", "I I", 'C', new ItemStack(ConfigItems.itemWandCap, 1, 1), 'I',
                    new ItemStack(ConfigBlocks.blockMagicalLog, 1, 0) });

            ShapedArcaneRecipe thaumiumBraceletRec = new ShapedArcaneRecipe(
                "TB.Bracelet.Thaumium",
                new ItemStack(TBItems.castingBracelet, 1, 3),
                primals(25),
                new Object[] { "CIC", "INI", "N N", 'C', new ItemStack(TBItems.resource, 1, 2), 'I',
                    new ItemStack(ConfigItems.itemResource, 1, 2), 'N',
                    new ItemStack(ConfigItems.itemResource, 1, 14) });

            InfusionRecipe silverwoodBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Silverwood",
                new ItemStack(TBItems.castingBracelet, 1, 4),
                5,
                primals(17).add(Aspect.MAGIC, 17),
                new ItemStack(ConfigItems.itemWandRod, 1, 2),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1),
                    new ItemStack(ConfigBlocks.blockCrystal, 1, 6), new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1),
                    new ItemStack(ConfigBlocks.blockCrystal, 1, 6) });

            InfusionRecipe voidBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Void",
                new ItemStack(TBItems.castingBracelet, 1, 11),
                8,
                new AspectList().add(Aspect.ELDRITCH, 64)
                    .add(Aspect.VOID, 64)
                    .add(Aspect.MAGIC, 64)
                    .add(Aspect.AURA, 24)
                    .add(Aspect.ENERGY, 24),
                new ItemStack(TBItems.resource, 1, 4),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 2), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 16), new ItemStack(TBBlocks.crystalBlock, 1, 6),
                    new ItemStack(ConfigItems.itemWandCap, 1, 2), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 16), new ItemStack(TBBlocks.crystalBlock, 1, 6) });

            InfusionRecipe reedBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Reed",
                new ItemStack(TBItems.castingBracelet, 1, 5),
                2,
                new AspectList().add(Aspect.AIR, 24)
                    .add(Aspect.MOTION, 12)
                    .add(Aspect.MAGIC, 8),
                new ItemStack(ConfigItems.itemWandRod, 1, 5),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 0), new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 0) });

            InfusionRecipe boneBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Bone",
                new ItemStack(TBItems.castingBracelet, 1, 6),
                2,
                new AspectList().add(Aspect.ENTROPY, 24)
                    .add(Aspect.UNDEAD, 12)
                    .add(Aspect.MAGIC, 8),
                new ItemStack(ConfigItems.itemWandRod, 1, 7),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 5), new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 5) });

            InfusionRecipe obsidianBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Obsidian",
                new ItemStack(TBItems.castingBracelet, 1, 7),
                2,
                new AspectList().add(Aspect.EARTH, 24)
                    .add(Aspect.DARKNESS, 12)
                    .add(Aspect.MAGIC, 8),
                new ItemStack(ConfigItems.itemWandRod, 1, 1),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 3), new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 3) });

            InfusionRecipe blazeBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Blaze",
                new ItemStack(TBItems.castingBracelet, 1, 8),
                2,
                new AspectList().add(Aspect.FIRE, 24)
                    .add(Aspect.BEAST, 12)
                    .add(Aspect.MAGIC, 8),
                new ItemStack(ConfigItems.itemWandRod, 1, 6),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 1) });

            InfusionRecipe iceBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Ice",
                new ItemStack(TBItems.castingBracelet, 1, 9),
                2,
                new AspectList().add(Aspect.WATER, 24)
                    .add(Aspect.COLD, 12)
                    .add(Aspect.MAGIC, 8),
                new ItemStack(ConfigItems.itemWandRod, 1, 3),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 2), new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 2) });

            InfusionRecipe quartzBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Quartz",
                new ItemStack(TBItems.castingBracelet, 1, 10),
                2,
                new AspectList().add(Aspect.ORDER, 24)
                    .add(Aspect.ENERGY, 12)
                    .add(Aspect.MAGIC, 8),
                new ItemStack(ConfigItems.itemWandRod, 1, 4),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 4), new ItemStack(ConfigItems.itemWandCap, 1, 2),
                    new ItemStack(ConfigItems.itemShard, 1, 4) });

            InfusionRecipe primalBraceletRec = new InfusionRecipe(
                "TB.Bracelet.Primal",
                new ItemStack(TBItems.castingBracelet, 1, 12),
                7,
                primals(48).add(Aspect.MAGIC, 96),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(ConfigItems.itemWandCap, 1, 7),
                    new ItemStack(TBItems.castingBracelet, 1, 5), new ItemStack(TBItems.castingBracelet, 1, 6),
                    new ItemStack(TBItems.castingBracelet, 1, 7), new ItemStack(ConfigItems.itemWandCap, 1, 7),
                    new ItemStack(TBItems.castingBracelet, 1, 8), new ItemStack(TBItems.castingBracelet, 1, 9),
                    new ItemStack(TBItems.castingBracelet, 1, 10) });

            new ResearchItem(
                "TB.Bracelet.Iron",
                catName,
                new AspectList().add(Aspect.METAL, 3)
                    .add(Aspect.MAGIC, 3),
                -6,
                7,
                0,
                new ItemStack(TBItems.castingBracelet, 1, 0)).setRound()
                    .setPages(
                        new ResearchPage("tb.rec.bracelet.iron.page.0"),
                        new ResearchPage("tb.rec.bracelet.iron.page.1"),
                        new ResearchPage("tb.rec.bracelet.iron.page.2"),
                        new ResearchPage(ironBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Gold",
                catName,
                new AspectList().add(Aspect.METAL, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.GREED, 3),
                -8,
                8,
                0,
                new ItemStack(TBItems.castingBracelet, 1, 1)).setParents("TB.Bracelet.Iron", "TB.CAP_gold")
                    .setPages(new ResearchPage("tb.rec.bracelet.gold.page.0"), new ResearchPage(goldBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Greatwood",
                catName,
                new AspectList().add(Aspect.TREE, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.ENERGY, 3),
                -10,
                8,
                0,
                new ItemStack(TBItems.castingBracelet, 1, 2)).setConcealed()
                    .setParents("TB.Bracelet.Gold", "TB.ROD_greatwood")
                    .setPages(
                        new ResearchPage("tb.rec.bracelet.greatwood.page.0"),
                        new ResearchPage(greatwoodBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Thaumium",
                catName,
                new AspectList().add(Aspect.METAL, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.ENERGY, 3)
                    .add(Aspect.AURA, 3),
                -10,
                11,
                0,
                new ItemStack(TBItems.castingBracelet, 1, 3)).setConcealed()
                    .setParents("TB.Bracelet.Greatwood")
                    .setParentsHidden("TB.THAUMIUM", "CAP_thauminite")
                    .setPages(
                        new ResearchPage("tb.rec.bracelet.thaumium.page.0"),
                        new ResearchPage(thaumiumBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Silverwood",
                catName,
                new AspectList().add(Aspect.ORDER, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.TREE, 3)
                    .add(Aspect.AURA, 3)
                    .add(Aspect.EXCHANGE, 3),
                -12,
                8,
                1,
                new ItemStack(TBItems.castingBracelet, 1, 4)).setConcealed()
                    .setParents("TB.Bracelet.Greatwood", "TB.ROD_silverwood")
                    .setPages(
                        new ResearchPage("tb.rec.bracelet.silverwood.page.0"),
                        new ResearchPage(silverwoodBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Void",
                catName,
                new AspectList().add(Aspect.VOID, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.ELDRITCH, 3)
                    .add(Aspect.AURA, 3)
                    .add(Aspect.EXCHANGE, 3),
                -12,
                11,
                3,
                new ItemStack(TBItems.castingBracelet, 1, 11)).setConcealed()
                    .setParents("TB.Bracelet.Silverwood")
                    .setParentsHidden("TB.VOIDMETAL")
                    .setPages(new ResearchPage("tb.rec.bracelet.void.page.0"), new ResearchPage(voidBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Reed",
                catName,
                new AspectList().add(Aspect.AIR, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.CRAFT, 3)
                    .add(Aspect.AURA, 3)
                    .add(Aspect.EXCHANGE, 3),
                -19,
                6,
                2,
                new ItemStack(TBItems.castingBracelet, 1, 5)).setConcealed()
                    .setParents("TB.ROD_reed")
                    .setParentsHidden("TB.Bracelet.Greatwood")
                    .setPages(new ResearchPage("tb.rec.bracelet.reed.page.0"), new ResearchPage(reedBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Blaze",
                catName,
                new AspectList().add(Aspect.FIRE, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.CRAFT, 3)
                    .add(Aspect.AURA, 3)
                    .add(Aspect.EXCHANGE, 3),
                -15,
                6,
                2,
                new ItemStack(TBItems.castingBracelet, 1, 8)).setConcealed()
                    .setParents("TB.ROD_blaze")
                    .setParentsHidden("TB.Bracelet.Greatwood")
                    .setPages(new ResearchPage("tb.rec.bracelet.blaze.page.0"), new ResearchPage(blazeBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Obsidian",
                catName,
                new AspectList().add(Aspect.EARTH, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.CRAFT, 3)
                    .add(Aspect.AURA, 3)
                    .add(Aspect.EXCHANGE, 3),
                -19,
                10,
                2,
                new ItemStack(TBItems.castingBracelet, 1, 7)).setConcealed()
                    .setParents("TB.ROD_obsidian")
                    .setParentsHidden("TB.Bracelet.Greatwood")
                    .setPages(
                        new ResearchPage("tb.rec.bracelet.obsidian.page.0"),
                        new ResearchPage(obsidianBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Ice",
                catName,
                new AspectList().add(Aspect.WATER, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.CRAFT, 3)
                    .add(Aspect.AURA, 3)
                    .add(Aspect.EXCHANGE, 3),
                -17,
                6,
                2,
                new ItemStack(TBItems.castingBracelet, 1, 9)).setConcealed()
                    .setParents("TB.ROD_ice")
                    .setParentsHidden("TB.Bracelet.Greatwood")
                    .setPages(new ResearchPage("tb.rec.bracelet.ice.page.0"), new ResearchPage(iceBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Quartz",
                catName,
                new AspectList().add(Aspect.ORDER, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.CRAFT, 3)
                    .add(Aspect.AURA, 3)
                    .add(Aspect.EXCHANGE, 3),
                -17,
                10,
                2,
                new ItemStack(TBItems.castingBracelet, 1, 10)).setConcealed()
                    .setParents("TB.ROD_quartz")
                    .setParentsHidden("TB.Bracelet.Greatwood")
                    .setPages(new ResearchPage("tb.rec.bracelet.quartz.page.0"), new ResearchPage(quartzBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Bone",
                catName,
                new AspectList().add(Aspect.ENTROPY, 3)
                    .add(Aspect.MAGIC, 3)
                    .add(Aspect.CRAFT, 3)
                    .add(Aspect.AURA, 3)
                    .add(Aspect.EXCHANGE, 3),
                -15,
                10,
                2,
                new ItemStack(TBItems.castingBracelet, 1, 6)).setConcealed()
                    .setParents("TB.ROD_bone")
                    .setParentsHidden("TB.Bracelet.Greatwood")
                    .setPages(new ResearchPage("tb.rec.bracelet.bone.page.0"), new ResearchPage(boneBraceletRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Bracelet.Primal",
                catName,
                primals(6).add(Aspect.MAGIC, 12)
                    .add(Aspect.ELDRITCH, 12),
                -17,
                8,
                4,
                new ItemStack(TBItems.castingBracelet, 1, 12)).setConcealed()
                    .setSpecial()
                    .setParents(
                        "TB.ROD_primal_staff",
                        "TB.Bracelet.Bone",
                        "TB.Bracelet.Quartz",
                        "TB.Bracelet.Ice",
                        "TB.Bracelet.Obsidian",
                        "TB.Bracelet.Blaze",
                        "TB.Bracelet.Reed",
                        "TB.Bracelet.Silverwood")
                    .setPages(new ResearchPage("tb.rec.bracelet.primal.page.0"), new ResearchPage(primalBraceletRec))
                    .registerResearchItem();

            ThaumcraftApi.getCraftingRecipes()
                .add(ironBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(goldBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(greatwoodBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(thaumiumBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(silverwoodBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(voidBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(reedBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(boneBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(obsidianBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(blazeBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(iceBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(quartzBraceletRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(primalBraceletRec);
        }

        // TODO Flora
        if (TBConfig.enableFlora) {

            ThaumcraftApi.addWarpToResearch("TB.Aurelia", 2);
            ThaumcraftApi.addWarpToResearch("TB.Flaxium", 2);
            ThaumcraftApi.addWarpToResearch("TB.Lucrite", 1);

            CrucibleRecipe plaxRec = new CrucibleRecipe(
                "TB.Plax",
                new ItemStack(TBItems.plaxSeed, 1, 0),
                new ItemStack(Items.wheat_seeds),
                new AspectList().add(Aspect.CLOTH, 4));
            CrucibleRecipe metalleatRec = new CrucibleRecipe(
                "TB.Metalleat",
                new ItemStack(TBItems.metalleatSeeds, 1, 0),
                new ItemStack(Items.wheat_seeds),
                new AspectList().add(Aspect.ORDER, 4)
                    .add(Aspect.METAL, 12)
                    .add(Aspect.LIFE, 4));
            CrucibleRecipe lucriteRec = new CrucibleRecipe(
                "TB.Lucrite",
                new ItemStack(TBItems.lucriteSeeds, 1, 0),
                new ItemStack(Items.golden_carrot),
                new AspectList().add(Aspect.HUNGER, 4)
                    .add(Aspect.GREED, 12)
                    .add(Aspect.LIFE, 4));

            CrucibleRecipe aureliaRec = new CrucibleRecipe(
                "TB.Aurelia",
                new ItemStack(TBBlocks.aurelia),
                new ItemStack(Blocks.red_flower, 1, 7),
                new AspectList().add(Aspect.PLANT, 8)
                    .add(Aspect.ELDRITCH, 2)
                    .add(Aspect.AURA, 2));
            CrucibleRecipe knoseRec = new CrucibleRecipe(
                "TB.Knose",
                new ItemStack(TBItems.knoseSeed),
                new ItemStack(Blocks.double_plant, 1, 4),
                new AspectList().add(Aspect.MIND, 16)
                    .add(Aspect.LIFE, 8)
                    .add(Aspect.ENERGY, 2));
            CrucibleRecipe knowledgeFragmentRec = new CrucibleRecipe(
                "TB.Knose",
                new ItemStack(ConfigItems.itemResource, 1, 9),
                new ItemStack(TBItems.knoseFragment, 1, OreDictionary.WILDCARD_VALUE),
                new AspectList().add(Aspect.ORDER, 1)
                    .add(Aspect.EXCHANGE, 1));
            CrucibleRecipe sweedRec = new CrucibleRecipe(
                "TB.BasicPlants",
                new ItemStack(TBItems.sweedSeeds),
                new ItemStack(Blocks.tallgrass, 1, OreDictionary.WILDCARD_VALUE),
                new AspectList().add(Aspect.MOTION, 2)
                    .add(Aspect.LIFE, 1));
            CrucibleRecipe lazulliaRec = new CrucibleRecipe(
                "TB.Lazullia",
                new ItemStack(TBItems.lazulliaSeeds),
                new ItemStack(Items.wheat_seeds),
                new AspectList().add(Aspect.SENSES, 12)
                    .add(Aspect.GREED, 3));
            CrucibleRecipe rainbowCactiRec = new CrucibleRecipe(
                "TB.RainbowCacti",
                new ItemStack(TBBlocks.rainbowCactus),
                new ItemStack(Blocks.cactus),
                new AspectList().add(Aspect.EXCHANGE, 24)
                    .add(Aspect.SENSES, 6));
            CrucibleRecipe redlonRec = new CrucibleRecipe(
                "TB.Redlon",
                new ItemStack(TBItems.redlonSeeds),
                new ItemStack(Items.melon_seeds),
                new AspectList().add(Aspect.MECHANISM, 16)
                    .add(Aspect.ENERGY, 16));
            CrucibleRecipe aspectShroomRec = new CrucibleRecipe(
                "TB.Ashroom",
                new ItemStack(TBBlocks.ashroom, 1, 0),
                new ItemStack(ConfigBlocks.blockCustomPlant, 1, 5),
                new AspectList().add(Aspect.ENTROPY, 4)
                    .add(Aspect.CROP, 2));
            CrucibleRecipe flaxiumRec = new CrucibleRecipe(
                "TB.Flaxium",
                new ItemStack(TBBlocks.flaxium, 1, 0),
                new ItemStack(Blocks.red_flower, 1, 2),
                new AspectList().add(Aspect.ENTROPY, 1)
                    .add(Aspect.MAGIC, 2));
            CrucibleRecipe glieoniaRec = new CrucibleRecipe(
                "TB.Glieonia",
                new ItemStack(TBItems.glieoniaSeed, 1, 0),
                new ItemStack(Blocks.red_flower, 1, 3),
                new AspectList().add(Aspect.LIGHT, 8)
                    .add(Aspect.MAGIC, 6)
                    .add(Aspect.LIFE, 4));
            CrucibleRecipe briarRec = new CrucibleRecipe(
                "TB.Briar",
                new ItemStack(TBBlocks.briar, 1, 0),
                new ItemStack(Blocks.double_plant, 1, 4),
                new AspectList().add(Aspect.HEAL, 4)
                    .add(Aspect.LIFE, 4)
                    .add(Aspect.PLANT, 4));

            ShapelessArcaneRecipe rosehipRec = new ShapelessArcaneRecipe(
                "TB.Briar",
                TBItems.rosehipSyrup,
                new AspectList().add(Aspect.FIRE, 3)
                    .add(Aspect.WATER, 5),
                new Object[] { new ItemStack(ConfigItems.itemEssence, 1, 0), new ItemStack(TBItems.resource, 1, 6),
                    new ItemStack(Items.sugar, 1, 0) });

            InfusionRecipe voidSeedRec = new InfusionRecipe(
                "TB.VoidSeed",
                new ItemStack(TBItems.voidSeed, 1, 0),
                3,
                new AspectList().add(Aspect.ELDRITCH, 16)
                    .add(Aspect.DARKNESS, 16)
                    .add(Aspect.CROP, 16),
                new ItemStack(ConfigItems.itemResource, 1, 17),
                new ItemStack[] { new ItemStack(Items.wheat_seeds, 1, 0), new ItemStack(Items.pumpkin_seeds, 1, 0),
                    new ItemStack(Items.melon_seeds, 1, 0), new ItemStack(Items.poisonous_potato, 1, 0),
                    new ItemStack(Items.carrot, 1, 0), new ItemStack(Items.nether_wart, 1, 0), });

            InfusionRecipe goldenOakRec = new InfusionRecipe(
                "TB.GoldenOak",
                new ItemStack(TBBlocks.sapling),
                2,
                new AspectList().add(Aspect.PLANT, 16)
                    .add(Aspect.GREED, 64),
                new ItemStack(Blocks.sapling, 1, 0),
                new ItemStack[] { new ItemStack(Items.apple), new ItemStack(Items.apple),
                    new ItemStack(Items.golden_apple), new ItemStack(Items.golden_apple) });

            InfusionRecipe peacefulSaplingRec = new InfusionRecipe(
                "TB.PeacefulSapling",
                new ItemStack(TBBlocks.sapling, 1, 1),
                2,
                new AspectList().add(Aspect.TREE, 16)
                    .add(Aspect.LIFE, 12)
                    .add(Aspect.HEAL, 6),
                new ItemStack(Blocks.sapling, 1, 2),
                new ItemStack[] { new ItemStack(Items.slime_ball), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(Items.slime_ball), new ItemStack(ConfigBlocks.blockCustomPlant, 1, 2),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigBlocks.blockMetalDevice, 1, 13),
                    new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 2) });

            InfusionRecipe netherSaplingRec = new InfusionRecipe(
                "TB.NetherSapling",
                new ItemStack(TBBlocks.sapling, 1, 2),
                5,
                new AspectList().add(Aspect.TREE, 32)
                    .add(nether, 32)
                    .add(Aspect.HUNGER, 16),
                new ItemStack(ConfigBlocks.blockCustomPlant, 1, 0),
                new ItemStack[] { new ItemStack(ConfigBlocks.blockCustomPlant, 1, 3),
                    new ItemStack(ConfigItems.itemShard, 1, 1), new ItemStack(ConfigBlocks.blockCustomPlant, 1, 3),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 3),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 3), new ItemStack(ConfigItems.itemShard, 1, 1),
                    new ItemStack(Items.lava_bucket, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 1),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4) });

            InfusionRecipe enderSaplingRec = new InfusionRecipe(
                "TB.EnderSapling",
                new ItemStack(TBBlocks.sapling, 1, 3),
                7,
                new AspectList().add(Aspect.TREE, 64)
                    .add(Aspect.ELDRITCH, 24)
                    .add(Aspect.VOID, 16)
                    .add(Aspect.DARKNESS, 8),
                new ItemStack(ConfigBlocks.blockCustomPlant, 1, 1),
                new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(Items.ender_pearl, 1, 0),
                    new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(ConfigItems.itemResource, 1, 1),
                    new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(Items.ender_pearl, 1, 0),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4), new ItemStack(ConfigItems.itemShard, 1, 6),
                    new ItemStack(Items.ender_pearl, 1, 0), new ItemStack(ConfigItems.itemShard, 1, 6),
                    new ItemStack(ConfigItems.itemResource, 1, 1) });

            new ResearchItem(
                "TB.BasicPlants",
                catName,
                new AspectList().add(Aspect.CROP, 2)
                    .add(Aspect.PLANT, 2),
                -8,
                -2,
                1,
                new ItemStack(Items.wheat_seeds, 1, 0)).setParentsHidden("TB.CRUCIBLE")
                    .setRound()
                    .setPages(new ResearchPage("tb.rec.basicPlants.page.0"), new ResearchPage(sweedRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Plax",
                catName,
                new AspectList().add(Aspect.CROP, 1)
                    .add(Aspect.CLOTH, 1),
                -11,
                -2,
                1,
                new ItemStack(TBItems.plaxSeed, 1, 0)).setParents("TB.BasicPlants")
                    .setPages(new ResearchPage("tb.rec.plax.page.0"), new ResearchPage(plaxRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Briar",
                catName,
                new AspectList().add(Aspect.CROP, 4)
                    .add(Aspect.PLANT, 4)
                    .add(Aspect.HEAL, 4),
                -13,
                -3,
                1,
                new ItemStack(TBItems.resource, 1, 6)).setParents("TB.Plax")
                    .setConcealed()
                    .setPages(
                        new ResearchPage("tb.rec.briar.page.0"),
                        new ResearchPage(briarRec),
                        new ResearchPage(rosehipRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Aurelia",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.MAGIC, 6)
                    .add(Aspect.AURA, 6),
                -10,
                0,
                0,
                new ItemStack(TBBlocks.aurelia, 1, 0)).setParents("TB.BasicPlants")
                    .setPages(
                        new ResearchPage("tb.rec.aurelia.page.0"),
                        new ResearchPage("tb.rec.aurelia.page.1"),
                        new ResearchPage(aureliaRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Knose",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.MIND, 6)
                    .add(Aspect.EARTH, 6),
                -10,
                2,
                0,
                new ItemStack(TBItems.knoseFragment, 1, OreDictionary.WILDCARD_VALUE)).setParents("TB.Aurelia")
                    .setParentsHidden("TB.CrystalBlocks")
                    .setConcealed()
                    .setPages(
                        new ResearchPage("tb.rec.knose.page.0"),
                        new ResearchPage("tb.rec.knose.page.1"),
                        new ResearchPage(knoseRec),
                        new ResearchPage(knowledgeFragmentRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Ashroom",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.ENTROPY, 6)
                    .add(Aspect.AURA, 6)
                    .add(Aspect.AIR, 6)
                    .add(Aspect.CROP, 4),
                -9,
                2,
                2,
                new ItemStack(TBBlocks.ashroom)).setParents("TB.Aurelia")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.ashroom.page.0"), new ResearchPage(aspectShroomRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Glieonia",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.LIGHT, 6)
                    .add(Aspect.SENSES, 6)
                    .add(Aspect.FIRE, 6)
                    .add(Aspect.PLANT, 4),
                -12,
                1,
                2,
                new ItemStack(TBItems.glieoniaSeed)).setParents("TB.Aurelia")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.glieonia.page.0"), new ResearchPage(glieoniaRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Flaxium",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.ENTROPY, 6)
                    .add(Aspect.AURA, 6)
                    .add(Aspect.MAGIC, 6),
                -11,
                2,
                2,
                new ItemStack(TBBlocks.flaxium)).setParents("TB.Aurelia")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.flaxium.page.0"), new ResearchPage(flaxiumRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Metalleat",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.MAGIC, 6)
                    .add(Aspect.METAL, 6)
                    .add(Aspect.EXCHANGE, 6),
                -10,
                -4,
                0,
                new ItemStack(TBItems.metalleatSeeds, 1, 0)).setParents("TB.BasicPlants")
                    .setPages(new ResearchPage("tb.rec.metalleat.page.0"), new ResearchPage(metalleatRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Lazullia",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.MAGIC, 6)
                    .add(Aspect.GREED, 6)
                    .add(Aspect.CRYSTAL, 6)
                    .add(Aspect.PLANT, 6)
                    .add(Aspect.SENSES, 8),
                -8,
                -5,
                2,
                new ItemStack(TBItems.lazulliaSeeds, 1, 0)).setParents("TB.Metalleat")
                    .setConcealed()
                    .setPages(
                        new ResearchPage(
                            "tb.rec.lazullia.page.0" + (Loader.isModLoaded("essentialcraft") ? "_ec3" : "")),
                        new ResearchPage(lazulliaRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.RainbowCacti",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.MAGIC, 6)
                    .add(Aspect.EXCHANGE, 6)
                    .add(Aspect.CROP, 6)
                    .add(Aspect.ENTROPY, 6)
                    .add(Aspect.SENSES, 8),
                -11,
                -6,
                2,
                new ItemStack(TBBlocks.rainbowCactus, 1, 0)).setParents("TB.Metalleat")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.rainCacti.page.0"), new ResearchPage(rainbowCactiRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Lucrite",
                catName,
                new AspectList().add(Aspect.GREED, 6)
                    .add(Aspect.MAGIC, 6)
                    .add(Aspect.PLANT, 6)
                    .add(Aspect.HUNGER, 6),
                -9,
                -6,
                0,
                new ItemStack(TBItems.lucriteSeeds, 1, 0)).setParents("TB.Metalleat")
                    .setParentsHidden("TB.SMB")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.lucrite.page.0"), new ResearchPage(lucriteRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Redlon",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.MECHANISM, 6)
                    .add(Aspect.ENERGY, 6)
                    .add(Aspect.CROP, 6)
                    .add(Aspect.ORDER, 6)
                    .add(Aspect.GREED, 8),
                -10,
                -6,
                3,
                new ItemStack(TBItems.redlonSeeds, 1, 0)).setParents("TB.Metalleat")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.redlon.page.0"), new ResearchPage(redlonRec))
                    .registerResearchItem();

            // void seed
            new ResearchItem(
                "TB.VoidSeed",
                catName,
                new AspectList().add(Aspect.LIFE, 6)
                    .add(Aspect.ELDRITCH, 6)
                    .add(Aspect.DARKNESS, 6),
                16,
                3,
                1,
                new ItemStack(TBItems.voidSeed, 1, 0)).setParents("TB.VOIDMETAL")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.voidSeed.page.0"), new ResearchPage(voidSeedRec))
                    .registerResearchItem();

            // saplings
            new ResearchItem(
                "TB.GoldenOak",
                catName,
                new AspectList().add(Aspect.GREED, 8)
                    .add(Aspect.HUNGER, 8)
                    .add(Aspect.CROP, 8),
                -15,
                -1,
                0,
                new ItemStack(TBBlocks.sapling, 1, 0)).setParents("TB.Briar")
                    .setParentsHidden("TB.INFUSION")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.goldenOak.page.0"), new ResearchPage(goldenOakRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.PeacefulSapling",
                catName,
                new AspectList().add(Aspect.LIFE, 8)
                    .add(Aspect.HEAL, 8)
                    .add(Aspect.TREE, 8),
                -18,
                -1,
                0,
                new ItemStack(TBBlocks.sapling, 1, 1)).setParents("TB.GoldenOak")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.peacefulTree.page.0"), new ResearchPage(peacefulSaplingRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NetherSapling",
                catName,
                new AspectList().add(Aspect.TREE, 8)
                    .add(Aspect.FIRE, 8)
                    .add(nether, 8),
                -17,
                0,
                0,
                new ItemStack(TBBlocks.sapling, 1, 2)).setParents("TB.GoldenOak")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.netherTree.page.0"), new ResearchPage(netherSaplingRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.EnderSapling",
                catName,
                new AspectList().add(Aspect.TREE, 8)
                    .add(Aspect.ELDRITCH, 8)
                    .add(Aspect.VOID, 8),
                -17,
                -2,
                0,
                new ItemStack(TBBlocks.sapling, 1, 3)).setParents("TB.GoldenOak")
                    .setConcealed()
                    .setPages(new ResearchPage("tb.rec.enderTree.page.0"), new ResearchPage(enderSaplingRec))
                    .registerResearchItem();

            ThaumcraftApi.getCraftingRecipes()
                .add(plaxRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(metalleatRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(lucriteRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(knoseRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(knowledgeFragmentRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(sweedRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(lazulliaRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(rainbowCactiRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(redlonRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(aspectShroomRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(flaxiumRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(glieoniaRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(briarRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(rosehipRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(aureliaRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(voidSeedRec);

            ThaumcraftApi.getCraftingRecipes()
                .add(peacefulSaplingRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(netherSaplingRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(enderSaplingRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(goldenOakRec);
        }

        // TODO nodes
        if (TBConfig.enableNodeTools) {

            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("NODESTABILIZERADV"),"TB.NODESTABILIZERADV",catName,-2,-7).setConcealed().setHidden().registerResearchItem();
            // copy(ResearchCategories.getResearchList("THAUMATURGY").research.get("VISPOWER"),"TB.VISPOWER",catName,2,-7).setConcealed().setHidden().registerResearchItem();

            new FakeResearchItem(
                "TB.NODESTABILIZERADV",
                "THAUMICBASES",
                "NODESTABILIZERADV",
                "THAUMATURGY",
                -2,
                -7,
                ResearchCategories.getResearch("NODESTABILIZERADV").icon_item).registerResearchItem();
            new FakeResearchItem(
                "TB.VISPOWER",
                "THAUMICBASES",
                "VISPOWER",
                "THAUMATURGY",
                2,
                -7,
                ResearchCategories.getResearch("VISPOWER").icon_item).registerResearchItem();

            ThaumcraftApi.addWarpToResearch("TB.NodeMan", 1);
            ThaumcraftApi.addWarpToResearch("TB.NodeFoci.Destr", 2);
            ThaumcraftApi.addWarpToResearch("TB.NodeFoci.Taint", 3);

            ThaumcraftApi.addWarpToItem(new ItemStack(TBItems.nodeFoci, 1, 1), 1);
            ThaumcraftApi.addWarpToItem(new ItemStack(TBItems.nodeFoci, 1, 9), 2);

            InfusionRecipe nodeManipulatorRec = new InfusionRecipe(
                "TB.NodeMan",
                new ItemStack(TBBlocks.nodeManipulator, 1, 0),
                6,
                new AspectList().add(Aspect.MECHANISM, 32)
                    .add(Aspect.AURA, 32)
                    .add(Aspect.MAGIC, 16)
                    .add(Aspect.ENERGY, 64)
                    .add(Aspect.VOID, 16),
                new ItemStack(ConfigBlocks.blockStoneDevice, 1, 11),
                new ItemStack[] { new ItemStack(ConfigBlocks.blockStoneDevice, 1, 10),
                    new ItemStack(ConfigBlocks.blockMirror, 1, 0), new ItemStack(ConfigBlocks.blockMirror, 1, 6),
                    new ItemStack(ConfigBlocks.blockStoneDevice, 1, 14), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(ConfigBlocks.blockStoneDevice, 1, 10), new ItemStack(ConfigBlocks.blockMirror, 1, 0),
                    new ItemStack(ConfigBlocks.blockMirror, 1, 6), new ItemStack(ConfigBlocks.blockStoneDevice, 1, 14),
                    new ItemStack(TBBlocks.dustBlock, 1, 0) });

            boolean flag = TBConfig.brightFociRequiresPrimordialPearl;

            InfusionRecipe brightFociRec = new InfusionRecipe(
                "TB.NodeFoci.Bright",
                new ItemStack(TBItems.nodeFoci, 1, 0),
                3,
                new AspectList().add(Aspect.AURA, flag ? 256 : 64)
                    .add(Aspect.LIGHT, flag ? 64 : 16)
                    .add(Aspect.ENERGY, flag ? 256 : 32),
                flag ? new ItemStack(ConfigItems.itemEldritchObject, 1, 3)
                    : new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(ConfigBlocks.blockMetalDevice, 1, 7),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigBlocks.blockCustomPlant, 1, 3),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigBlocks.blockMetalDevice, 1, 7),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigBlocks.blockCustomPlant, 1, 3),
                    new ItemStack(ConfigItems.itemResource, 1, 14) });

            InfusionRecipe destructionFociRec = new InfusionRecipe(
                "TB.NodeFoci.Destr",
                new ItemStack(TBItems.nodeFoci, 1, 1),
                5,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.VOID, 16)
                    .add(Aspect.DEATH, 32),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 6),
                    new ItemStack(TBBlocks.crystalBlock, 1, 7), new ItemStack(ConfigBlocks.blockTube, 1, 7),
                    new ItemStack(ConfigItems.itemFocusExcavation, 1, 0), new ItemStack(ConfigItems.itemResource, 1, 6),
                    new ItemStack(TBBlocks.crystalBlock, 1, 7), new ItemStack(ConfigBlocks.blockTube, 1, 7),
                    new ItemStack(ConfigItems.itemFocusExcavation, 1, 0) });

            InfusionRecipe efficiencyFociRec = new InfusionRecipe(
                "TB.NodeFoci.Efficiency",
                new ItemStack(TBItems.nodeFoci, 1, 2),
                1,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.VOID, 16)
                    .add(Aspect.DEATH, 32),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(ConfigItems.itemShard, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0) });

            InfusionRecipe hungerFociRec = new InfusionRecipe(
                "TB.NodeFoci.Hunger",
                new ItemStack(TBItems.nodeFoci, 1, 3),
                7,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.VOID, 64)
                    .add(Aspect.HUNGER, 256)
                    .add(Aspect.GREED, 64)
                    .add(Aspect.ENERGY, 128),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigItems.itemThaumometer, 1, 0), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigBlocks.blockStoneDevice, 1, 11), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigItems.itemThaumometer, 1, 0), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigBlocks.blockStoneDevice, 1, 11) });

            InfusionRecipe unstableFociRec = new InfusionRecipe(
                "TB.NodeFoci.Unstable",
                new ItemStack(TBItems.nodeFoci, 1, 4),
                3,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.DEATH, 32)
                    .add(Aspect.ENTROPY, 64),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(Items.ender_pearl), new ItemStack(TBBlocks.crystalBlock, 1, 5),
                    new ItemStack(Items.ender_pearl), new ItemStack(TBBlocks.crystalBlock, 1, 5),
                    new ItemStack(Items.ender_pearl), new ItemStack(TBBlocks.crystalBlock, 1, 5),
                    new ItemStack(Items.ender_pearl), new ItemStack(TBBlocks.crystalBlock, 1, 5) });

            InfusionRecipe pureFociRec = new InfusionRecipe(
                "TB.NodeFoci.Purity",
                new ItemStack(TBItems.nodeFoci, 1, 5),
                0,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.LIFE, 64)
                    .add(Aspect.ORDER, 64),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(ConfigBlocks.blockCustomPlant, 1, 1),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4),
                    new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 2),
                    new ItemStack(ConfigBlocks.blockMagicalLeaves, 1, 1),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 4),
                    new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1),
                    new ItemStack(ConfigBlocks.blockCustomPlant, 1, 2) });

            InfusionRecipe sinisterFociRec = new InfusionRecipe(
                "TB.NodeFoci.Sinister",
                new ItemStack(TBItems.nodeFoci, 1, 6),
                4,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.DARKNESS, 32)
                    .add(Aspect.UNDEAD, 64),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(ConfigItems.itemWispEssence, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(TBBlocks.crystalBlock, 1, 7), new ItemStack(ConfigItems.itemFocusPech, 1, 0),
                    new ItemStack(TBBlocks.crystalBlock, 1, 6),
                    new ItemStack(ConfigItems.itemWispEssence, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(TBBlocks.crystalBlock, 1, 7), new ItemStack(ConfigItems.itemFocusPech, 1, 0),
                    new ItemStack(TBBlocks.crystalBlock, 1, 6) });

            InfusionRecipe speedFociRec = new InfusionRecipe(
                "TB.NodeFoci.Speed",
                new ItemStack(TBItems.nodeFoci, 1, 7),
                1,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.MOTION, 32)
                    .add(Aspect.MAGIC, 16),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(TBBlocks.crystalBlock, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(TBBlocks.crystalBlock, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(TBBlocks.crystalBlock, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(TBBlocks.crystalBlock, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0) });

            InfusionRecipe stabilityFociRec = new InfusionRecipe(
                "TB.NodeFoci.Stability",
                new ItemStack(TBItems.nodeFoci, 1, 8),
                1,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.ORDER, 32)
                    .add(Aspect.EXCHANGE, 16),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 10), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(TBBlocks.crystalBlock, 1, 6), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 10), new ItemStack(TBBlocks.dustBlock, 1, 0),
                    new ItemStack(TBBlocks.crystalBlock, 1, 6) });

            InfusionRecipe taintFociRec = new InfusionRecipe(
                "TB.NodeFoci.Taint",
                new ItemStack(TBItems.nodeFoci, 1, 9),
                5,
                new AspectList().add(Aspect.AURA, 64)
                    .add(Aspect.TAINT, 64)
                    .add(Aspect.ENTROPY, 16),
                new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 11),
                    new ItemStack(TBBlocks.crystalBlock, 1, 7), new ItemStack(ConfigItems.itemResource, 1, 12),
                    new ItemStack(TBItems.knoseFragment, 1, 7), new ItemStack(ConfigItems.itemResource, 1, 11),
                    new ItemStack(TBBlocks.crystalBlock, 1, 7), new ItemStack(ConfigItems.itemResource, 1, 12),
                    new ItemStack(TBItems.knoseFragment, 1, 7), });

            ShapedArcaneRecipe nodeLinkRec = new ShapedArcaneRecipe(
                "TB.NodeLinker",
                new ItemStack(TBBlocks.nodeLinker, 1, 0),
                primals(5),
                new Object[] { "TPT", "ANA", "BOB", 'T', new ItemStack(ConfigBlocks.blockMetalDevice, 1, 14), 'P',
                    new ItemStack(ConfigItems.itemResource, 1, 15), 'A',
                    new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 6), 'B',
                    new ItemStack(ConfigBlocks.blockCosmeticSolid, 1, 7), 'O', Blocks.obsidian, 'N',
                    new ItemStack(ConfigItems.itemResource, 1, 0) });

            new ResearchItem(
                "TB.NodeMan",
                catName,
                new AspectList().add(Aspect.MECHANISM, 8)
                    .add(Aspect.AURA, 8)
                    .add(Aspect.ENERGY, 16)
                    .add(Aspect.MAGIC, 8),
                0,
                -8,
                3,
                new ItemStack(TBBlocks.nodeManipulator))
                    .setParents("TB.INFUSION", "TB.NODESTABILIZERADV", "TB.VISPOWER")
                    .setConcealed()
                    .setPages(
                        new ResearchPage("tb.rec.nodeMan.page.0"),
                        new ResearchPage("tb.rec.nodeMan.page.1"),
                        new ResearchPage("tb.rec.nodeMan.page.2"),
                        new ResearchPage("tb.rec.nodeMan.page.3"),
                        new ResearchPage(nodeManipulatorRec))
                    .registerResearchItem();

            if (flag) {
                // copy(ResearchCategories.getResearchList("ELDRITCH").research.get("PRIMPEARL"),"TB.PRIMPEARL",catName,0,-13).setConcealed().setHidden().registerResearchItem();

                new FakeResearchItem(
                    "TB.PRIMPEARL",
                    "THAUMICBASES",
                    "PRIMPEARL",
                    "ELDRITCH",
                    0,
                    -13,
                    ResearchCategories.getResearch("PRIMPEARL").icon_item).registerResearchItem();
            }

            String[] bParents = flag ? new String[] { "TB.NodeMan", "TB.PRIMPEARL" } : new String[] { "TB.NodeMan" };

            new ResearchItem(
                "TB.NodeFoci.Bright",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.LIGHT, 8),
                0,
                -11,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 0)).setParents(bParents)
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.bright.page.0"), new ResearchPage(brightFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Destr",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.DEATH, 8)
                    .add(Aspect.VOID, 8),
                2,
                -10,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 1)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.destr.page.0"), new ResearchPage(destructionFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Efficiency",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.MAGIC, 8)
                    .add(Aspect.ENERGY, 8),
                -4,
                -8,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 2)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.efficiency.page.0"), new ResearchPage(efficiencyFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Hunger",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.HUNGER, 16)
                    .add(Aspect.ENERGY, 16),
                4,
                -9,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 3)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setSpecial()
                    .setPages(new ResearchPage("tb.rec.foci.hunger.page.0"), new ResearchPage(hungerFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Unstable",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.ENTROPY, 8)
                    .add(Aspect.VOID, 8),
                -2,
                -10,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 4)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.unstable.page.0"), new ResearchPage(unstableFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Purity",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.LIFE, 8)
                    .add(Aspect.ORDER, 8),
                -1,
                -11,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 5)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.pure.page.0"), new ResearchPage(pureFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Sinister",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.UNDEAD, 8)
                    .add(Aspect.ENTROPY, 8),
                -3,
                -10,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 6)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.sinister.page.0"), new ResearchPage(sinisterFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Speed",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.MOTION, 8)
                    .add(Aspect.ENERGY, 8),
                -4,
                -9,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 7)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.speed.page.0"), new ResearchPage(speedFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Stability",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.ORDER, 8)
                    .add(Aspect.EXCHANGE, 8),
                1,
                -11,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 8)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.stability.page.0"), new ResearchPage(stabilityFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeFoci.Taint",
                catName,
                new AspectList().add(Aspect.AURA, 8)
                    .add(Aspect.TAINT, 16)
                    .add(Aspect.ENERGY, 8),
                3,
                -10,
                0,
                new ItemStack(TBItems.nodeFoci, 1, 9)).setParents("TB.NodeMan")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.foci.taint.page.0"), new ResearchPage(taintFociRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.NodeLinker",
                catName,
                new AspectList().add(Aspect.MECHANISM, 8)
                    .add(Aspect.AURA, 8)
                    .add(Aspect.TRAVEL, 16)
                    .add(Aspect.MAGIC, 8),
                5,
                -6,
                3,
                new ItemStack(TBBlocks.nodeLinker)).setParents("TB.VISPOWER")
                    .setConcealed()
                    .setPages(
                        new ResearchPage("tb.rec.nodeLink.page.0"),
                        new ResearchPage("tb.rec.nodeLink.page.1"),
                        new ResearchPage("tb.rec.nodeLink.page.2"),
                        new ResearchPage(nodeLinkRec))
                    .registerResearchItem();

            ThaumcraftApi.getCraftingRecipes()
                .add(nodeManipulatorRec);

            ThaumcraftApi.getCraftingRecipes()
                .add(brightFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(destructionFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(efficiencyFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(hungerFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(unstableFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(pureFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(sinisterFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(speedFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(stabilityFociRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(taintFociRec);

            ThaumcraftApi.getCraftingRecipes()
                .add(nodeLinkRec);
        }

        // TODO revolver
        if (TBConfig.enableRevolver) {

            ThaumcraftApi.addWarpToResearch("TB.Revolver.Eldritch", 2);
            ThaumcraftApi.addWarpToResearch("TB.Revolver.Primal", 4);
            ThaumcraftApi.addWarpToResearch("TB.Revolver.Tainted", 3);
            ThaumcraftApi.addWarpToResearch("TB.Revolver.Void", 2);

            InfusionRecipe revolverRec = new InfusionRecipe(
                "TB.Revolver",
                new ItemStack(TBItems.revolver, 1, 0),
                5,
                new AspectList().add(Aspect.WEAPON, 256)
                    .add(Aspect.METAL, 32)
                    .add(Aspect.TREE, 16)
                    .add(Aspect.TOOL, 12)
                    .add(Aspect.ENERGY, 32)
                    .add(Aspect.MECHANISM, 12)
                    .add(Aspect.VOID, 16)
                    .add(Aspect.FIRE, 32),
                new ItemStack(Blocks.iron_block),
                new ItemStack[] { new ItemStack(Items.fire_charge, 1, 0), new ItemStack(Items.gunpowder, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 15), new ItemStack(ConfigBlocks.blockMagicalLog, 1, 0),
                    new ItemStack(Items.gunpowder, 1, 0),
                    new ItemStack(ConfigItems.itemFocusFire, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(Items.fire_charge, 1, 0), new ItemStack(Items.gunpowder, 1, 0),
                    new ItemStack(ConfigItems.itemBowBone, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(ConfigBlocks.blockMagicalLog, 1, 0), new ItemStack(Items.gunpowder, 1, 0),
                    new ItemStack(Blocks.redstone_torch, 1, 0) });

            RevolverInfusionRecipe accuracyRec = new RevolverInfusionRecipe(
                "TB.Revolver.Accuracy",
                RevolverUpgrade.accuracy,
                1,
                new AspectList().add(Aspect.ORDER, 8)
                    .add(Aspect.SENSES, 8),
                new ItemStack[] { new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(Items.carrot, 1, 0),
                    new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE) });

            RevolverInfusionRecipe atropodsRec = new RevolverInfusionRecipe(
                "TB.Revolver.Atropods",
                RevolverUpgrade.atropodsBane,
                1,
                new AspectList().add(Aspect.DEATH, 8)
                    .add(Aspect.BEAST, 8)
                    .add(Aspect.CLOTH, 8),
                new ItemStack[] { new ItemStack(Items.spider_eye, 1, 0),
                    new ItemStack(Items.fermented_spider_eye, 1, 0), new ItemStack(Items.spider_eye, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 14) });

            RevolverInfusionRecipe eldritchBRec = new RevolverInfusionRecipe(
                "TB.Revolver.EldritchBane",
                RevolverUpgrade.eldritchBane,
                2,
                new AspectList().add(Aspect.DEATH, 8)
                    .add(Aspect.ELDRITCH, 8),
                new ItemStack[] { new ItemStack(Items.ender_eye, 1, 0), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(Items.ender_pearl, 1, 0) });

            RevolverInfusionRecipe duelingRec = new RevolverInfusionRecipe(
                "TB.Revolver.Dueling",
                RevolverUpgrade.dueling,
                2,
                new AspectList().add(Aspect.DEATH, 8)
                    .add(Aspect.MAN, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.bed, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.ghast_tear, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 14) });

            RevolverInfusionRecipe efficiencyRec = new RevolverInfusionRecipe(
                "TB.Revolver.Efficiency",
                RevolverUpgrade.efficiency,
                0,
                new AspectList().add(Aspect.ORDER, 8)
                    .add(Aspect.EXCHANGE, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(Items.blaze_powder, 1, 0), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(Items.enchanted_book, 1, 0), new ItemStack(ConfigItems.itemResource, 1, 14) });

            RevolverInfusionRecipe eldritchRec = new RevolverInfusionRecipe(
                "TB.Revolver.Eldritch",
                RevolverUpgrade.eldritch,
                5,
                new AspectList().add(Aspect.ELDRITCH, 8)
                    .add(Aspect.VOID, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemEldritchObject, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemEldritchObject, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 14) });

            RevolverInfusionRecipe heavyRec = new RevolverInfusionRecipe(
                "TB.Revolver.Heavy",
                RevolverUpgrade.heavy,
                0,
                new AspectList().add(Aspect.WEAPON, 8)
                    .add(Aspect.METAL, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(Items.iron_sword, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(ConfigItems.itemResource, 1, 14) });

            RevolverInfusionRecipe knowledgeRec = new RevolverInfusionRecipe(
                "TB.Revolver.Knowledge",
                RevolverUpgrade.knowledge,
                0,
                new AspectList().add(Aspect.MIND, 8)
                    .add(Aspect.AURA, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemInkwell, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.book, 1, 0),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.paper, 1, 0) });

            RevolverInfusionRecipe piercingRec = new RevolverInfusionRecipe(
                "TB.Revolver.Piercing",
                RevolverUpgrade.piercig,
                12,
                new AspectList().add(Aspect.WEAPON, 32)
                    .add(Aspect.AIR, 64),
                new ItemStack[] { new ItemStack(ConfigItems.itemPrimalArrow, 1, 0),
                    new ItemStack(ConfigItems.itemPrimalArrow, 1, 1), new ItemStack(ConfigItems.itemPrimalArrow, 1, 2),
                    new ItemStack(Items.diamond_sword, 1, OreDictionary.WILDCARD_VALUE),
                    new ItemStack(ConfigItems.itemPrimalArrow, 1, 3), new ItemStack(ConfigItems.itemPrimalArrow, 1, 4),
                    new ItemStack(ConfigItems.itemPrimalArrow, 1, 5) });

            RevolverInfusionRecipe powerRec = new RevolverInfusionRecipe(
                "TB.Revolver.Power",
                RevolverUpgrade.power,
                2,
                new AspectList().add(Aspect.WEAPON, 16),
                new ItemStack[] { new ItemStack(Items.gunpowder), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(Items.fire_charge), new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(Items.fireworks, 1, OreDictionary.WILDCARD_VALUE) });

            RevolverInfusionRecipe primalRec = new RevolverInfusionRecipe(
                "TB.Revolver.Primal",
                RevolverUpgrade.primal,
                12,
                new AspectList().add(Aspect.WEAPON, 64)
                    .add(primals(64))
                    .add(Aspect.MAGIC, 64),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigItems.itemEldritchObject, 1, 3), new ItemStack(Items.diamond),
                    new ItemStack(ConfigItems.itemEldritchObject, 1, 3),
                    new ItemStack(ConfigItems.itemResource, 1, 14), });

            ItemStack silver = OreDictionary.doesOreNameExist("ingotSilver")
                && OreDictionary.getOres("ingotSilver") != null
                && OreDictionary.getOres("ingotSilver")
                    .size() > 0 ? OreDictionary.getOres("ingotSilver")
                        .get(0) : new ItemStack(ConfigItems.itemResource, 1, 15);

            RevolverInfusionRecipe silverRec = new RevolverInfusionRecipe(
                "TB.Revolver.Silver",
                RevolverUpgrade.silver,
                0,
                new AspectList().add(Aspect.DEATH, 8)
                    .add(Aspect.BEAST, 8)
                    .add(Aspect.UNDEAD, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14),
                    new ItemStack(ConfigItems.itemResource, 1, 3), silver,
                    new ItemStack(ConfigItems.itemResource, 1, 3), new ItemStack(ConfigItems.itemResource, 1, 14), });

            RevolverInfusionRecipe speedRec = new RevolverInfusionRecipe(
                "TB.Revolver.Speed",
                RevolverUpgrade.speed,
                2,
                new AspectList().add(Aspect.MOTION, 8)
                    .add(Aspect.AIR, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(Items.feather),
                    new ItemStack(ConfigItems.itemResource, 1, 14), });

            RevolverInfusionRecipe taintedRec = new RevolverInfusionRecipe(
                "TB.Revolver.Tainted",
                RevolverUpgrade.tainted,
                4,
                new AspectList().add(Aspect.TAINT, 8)
                    .add(Aspect.WEAPON, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 11),
                    new ItemStack(ConfigItems.itemResource, 1, 14), new ItemStack(ConfigItems.itemResource, 1, 12),
                    new ItemStack(ConfigItems.itemResource, 1, 14) });

            RevolverInfusionRecipe voidRec = new RevolverInfusionRecipe(
                "TB.Revolver.Void",
                RevolverUpgrade.uvoid,
                4,
                new AspectList().add(Aspect.VOID, 8)
                    .add(Aspect.TOOL, 8),
                new ItemStack[] { new ItemStack(ConfigItems.itemResource, 1, 16),
                    new ItemStack(ConfigItems.itemResource, 1, 16), new ItemStack(ConfigItems.itemResource, 1, 16),
                    new ItemStack(ConfigItems.itemResource, 1, 16), new ItemStack(ConfigItems.itemResource, 1, 16) });

            new ResearchItem(
                "TB.Revolver",
                catName,
                new AspectList().add(Aspect.WEAPON, 5)
                    .add(Aspect.FIRE, 5)
                    .add(Aspect.VOID, 4)
                    .add(Aspect.TOOL, 2)
                    .add(Aspect.ENERGY, 2),
                -16,
                -7,
                4,
                new ItemStack(TBItems.revolver, 1, 0)).setParentsHidden("TB.INFUSION")
                    .setConcealed()
                    .setPages(
                        new ResearchPage("tb.rec.revolver.page.0"),
                        new ResearchPage("tb.rec.revolver.page.1"),
                        new ResearchPage("tb.rec.revolver.page.2"),
                        new ResearchPage(revolverRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Accuracy",
                catName,
                new AspectList().add(Aspect.ORDER, 8)
                    .add(Aspect.MECHANISM, 8)
                    .add(Aspect.SENSES, 4),
                -19,
                -7,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/ACCURACY.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.acc.page.0"), new ResearchPage(accuracyRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Atropods",
                catName,
                new AspectList().add(Aspect.DEATH, 8)
                    .add(Aspect.BEAST, 8)
                    .add(Aspect.CLOTH, 4),
                -14,
                -10,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/BANE_OF_ATROPODS.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.atr.page.0"), new ResearchPage(atropodsRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.EldritchBane",
                catName,
                new AspectList().add(Aspect.DEATH, 8)
                    .add(Aspect.ELDRITCH, 4),
                -13,
                -8,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/BANE_OF_ELDRITCH.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.elb.page.0"), new ResearchPage(eldritchBRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Dueling",
                catName,
                new AspectList().add(Aspect.DEATH, 8)
                    .add(Aspect.MAN, 8),
                -15,
                -10,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/DUELING.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.duel.page.0"), new ResearchPage(duelingRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Efficiency",
                catName,
                new AspectList().add(Aspect.ORDER, 8)
                    .add(Aspect.EXCHANGE, 8),
                -19,
                -8,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/EFFICIENCY.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.eff.page.0"), new ResearchPage(efficiencyRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Eldritch",
                catName,
                new AspectList().add(Aspect.ELDRITCH, 8)
                    .add(Aspect.VOID, 8),
                -13,
                -7,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/ELDRITCH.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.eld.page.0"), new ResearchPage(eldritchRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Heavy",
                catName,
                new AspectList().add(Aspect.WEAPON, 8)
                    .add(Aspect.METAL, 8),
                -19,
                -6,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/HEAVY.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.hev.page.0"), new ResearchPage(heavyRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Knowledge",
                catName,
                new AspectList().add(Aspect.MIND, 8)
                    .add(Aspect.MAGIC, 8),
                -18,
                -10,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/KNOWLEGDE.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.kno.page.0"), new ResearchPage(knowledgeRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Piercing",
                catName,
                new AspectList().add(Aspect.WEAPON, 8)
                    .add(Aspect.AIR, 8),
                -17,
                -10,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/PIERCING.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.pir.page.0"), new ResearchPage(piercingRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Power",
                catName,
                new AspectList().add(Aspect.WEAPON, 8)
                    .add(Aspect.MECHANISM, 8),
                -16,
                -10,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/POWER.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.pow.page.0"), new ResearchPage(powerRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Primal",
                catName,
                new AspectList().add(Aspect.WEAPON, 8)
                    .add(Aspect.AURA, 8)
                    .add(primals(16)),
                -15,
                -5,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/PRIMAL.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setSpecial()
                    .setPages(new ResearchPage("tb.rec.revolver.primal.page.0"), new ResearchPage(primalRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Silver",
                catName,
                new AspectList().add(Aspect.DEATH, 8)
                    .add(Aspect.UNDEAD, 8),
                -13,
                -9,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/SILVER.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.sil.page.0"), new ResearchPage(silverRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Speed",
                catName,
                new AspectList().add(Aspect.MOTION, 8)
                    .add(Aspect.AIR, 8),
                -19,
                -9,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/SPEED.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.spe.page.0"), new ResearchPage(speedRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Tainted",
                catName,
                new AspectList().add(Aspect.TAINT, 8)
                    .add(Aspect.MAGIC, 8),
                -18,
                -4,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/TAINTED.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.tai.page.0"), new ResearchPage(taintedRec))
                    .registerResearchItem();

            new ResearchItem(
                "TB.Revolver.Void",
                catName,
                new AspectList().add(Aspect.VOID, 8)
                    .add(Aspect.METAL, 8),
                -19,
                -5,
                0,
                new ResourceLocation("thaumicbases", "textures/thaumonomicon/revolver/VOID.png"))
                    .setParents("TB.Revolver")
                    .setConcealed()
                    .setSecondary()
                    .setPages(new ResearchPage("tb.rec.revolver.void.page.0"), new ResearchPage(voidRec))
                    .registerResearchItem();

            ThaumcraftApi.getCraftingRecipes()
                .add(revolverRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(accuracyRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(atropodsRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(eldritchBRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(duelingRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(efficiencyRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(eldritchRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(heavyRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(knowledgeRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(piercingRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(powerRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(primalRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(silverRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(speedRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(taintedRec);
            ThaumcraftApi.getCraftingRecipes()
                .add(voidRec);
        }

        // TODO void metal stuff
        ShapedOreRecipe voidShearsRec = new ShapedOreRecipe(
            new ItemStack(TBItems.voidShears),
            new Object[] { " #", "# ", '#', new ItemStack(ConfigItems.itemResource, 1, 16) });

        ShapedOreRecipe voidFlint = new ShapedOreRecipe(
            new ItemStack(TBItems.voidFAS),
            new Object[] { "# ", " C", '#', new ItemStack(ConfigItems.itemResource, 1, 16), 'C',
                new ItemStack(Items.flint) });

        ResearchItem voidIngot = ResearchCategories.getResearchList("ELDRITCH").research.get("VOIDMETAL");

        ResearchPage[] currentPages = voidIngot.getPages();
        ResearchPage[] newPages = new ResearchPage[currentPages.length + 4];
        System.arraycopy(currentPages, 0, newPages, 0, currentPages.length);
        newPages[newPages.length - 4] = new ResearchPage(voidFlint);
        newPages[newPages.length - 3] = new ResearchPage(voidShearsRec);
        newPages[newPages.length - 2] = new ResearchPage(voidBlockRec);
        newPages[newPages.length - 1] = new ResearchPage(voidIngotRec);
        voidIngot.setPages(newPages);

        CraftingManager.getInstance()
            .getRecipeList()
            .add(voidShearsRec);
        CraftingManager.getInstance()
            .getRecipeList()
            .add(voidFlint);

        CraftingManager.getInstance()
            .getRecipeList()
            .add(voidBlockRec);
        CraftingManager.getInstance()
            .getRecipeList()
            .add(voidIngotRec);

        // TODO entity decon

        InfusionRecipe entityDeconstructorRec = new InfusionRecipe(
            "TB.EntityDec",
            new ItemStack(TBBlocks.entityDeconstructor, 1, 0),
            4,
            new AspectList().add(Aspect.DEATH, 16)
                .add(Aspect.SOUL, 4)
                .add(Aspect.MIND, 16),
            new ItemStack(ConfigItems.itemThaumometer),
            new ItemStack[] { new ItemStack(Blocks.light_weighted_pressure_plate),
                new ItemStack(Blocks.light_weighted_pressure_plate),
                new ItemStack(Blocks.heavy_weighted_pressure_plate),
                new ItemStack(Blocks.heavy_weighted_pressure_plate), new ItemStack(ConfigItems.itemResource, 1, 9),
                new ItemStack(ConfigItems.itemResource, 1, 9), new ItemStack(ConfigItems.itemResource, 1, 15),
                new ItemStack(ConfigItems.itemResource, 1, 15) });

        new ResearchItem(
            "TB.EntityDec",
            catName,
            new AspectList().add(Aspect.MIND, 8)
                .add(Aspect.DEATH, 8)
                .add(Aspect.SOUL, 8),
            3,
            -2,
            1,
            new ItemStack(TBBlocks.entityDeconstructor, 1, 0)).setParents("TB.INFUSION")
                .setSecondary()
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.eDec.page.0"), new ResearchPage(entityDeconstructorRec))
                .registerResearchItem();

        new ResearchItem(
            "TB.EntityDecAdv",
            catName,
            new AspectList().add(Aspect.MIND, 8)
                .add(Aspect.DEATH, 8),
            5,
            -3,
            1,
            new ItemStack(ConfigBlocks.blockCrystal, 1, OreDictionary.WILDCARD_VALUE)).setParents("TB.EntityDec")
                .setSecondary()
                .setConcealed()
                .setPages(new ResearchPage("tb.rec.eDeca.page.0"), new ResearchPage("tb.rec.eDeca.page.1"))
                .registerResearchItem();

        ThaumcraftApi.getCraftingRecipes()
            .add(entityDeconstructorRec);

        ThaumcraftApi.getCraftingRecipes()
            .add(drainFociRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(expFociRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(fluxFociRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(activationFociRec);

        ThaumcraftApi.getCraftingRecipes()
            .add(advFurnaceRecipe);
        ThaumcraftApi.getCraftingRecipes()
            .add(cryingObsidianRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(overchanterRec);

        ThaumcraftApi.getCraftingRecipes()
            .add(herobrinesScytheRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(relocatorRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(irelocatorRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(thaumicAnvilRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(voidAnvilRec);

        ThaumcraftApi.getCraftingRecipes()
            .add(campfireRec);
        ThaumcraftApi.getCraftingRecipes()
            .add(brazierRec);

        // TODO actual recipes

        for (int i = 0; i < 6; ++i) ThaumcraftApi.getCraftingRecipes()
            .add(shards[i]);

        for (int i = 0; i < oldRec.length; ++i) ThaumcraftApi.getCraftingRecipes()
            .add(oldRec[i]);

        for (int i = 0; i < 10; ++i) ThaumcraftApi.getCraftingRecipes()
            .add(toolsRec[i]);

        for (int i = 0; i < 7; ++i) {
            ThaumcraftApi.getCraftingRecipes()
                .add(cBlocks[i]);
            ThaumcraftApi.getCraftingRecipes()
                .add(cTaintedBlocks[i]);
        }
    }

    public static Aspect getPrimalForLoop(int loopInt) {
        switch (loopInt) {
            case 0:
                return Aspect.AIR;
            case 1:
                return Aspect.FIRE;
            case 2:
                return Aspect.WATER;
            case 3:
                return Aspect.EARTH;
            case 4:
                return Aspect.ORDER;
            case 5:
                return Aspect.ENTROPY;
            default:
                return Aspect.AIR;
        }
    }

    public static AspectList primals(int amount) {
        return new AspectList().add(Aspect.AIR, amount)
            .add(Aspect.WATER, amount)
            .add(Aspect.EARTH, amount)
            .add(Aspect.FIRE, amount)
            .add(Aspect.ORDER, amount)
            .add(Aspect.ENTROPY, amount);
    }

    /*
     * public static ResearchItem copy(ResearchItem res, String newKey, String newCat, int dC, int dR) { ResearchItem
     * rItem; if(res.icon_resource != null) rItem = new
     * ResearchItem(newKey,newCat,res.tags,dC,dR,res.getComplexity(),res.icon_resource); else rItem = new
     * ResearchItem(newKey,newCat,res.tags,dC,dR,res.getComplexity(),res.icon_item); rItem.parents = res.parents;
     * rItem.parentsHidden = res.parentsHidden; rItem.siblings = res.siblings; rItem.setPages(res.getPages());
     * rItem.setAspectTriggers(new Aspect[0]); rItem.setEntityTriggers(new String[0]); rItem.setItemTriggers(new
     * ItemStack[0]); if(res.isAutoUnlock()) rItem.setAutoUnlock(); if(res.isConcealed()) rItem.setConcealed();
     * if(res.isHidden()) rItem.setHidden(); if(res.isLost()) rItem.setLost(); if(res.isRound()) rItem.setRound();
     * if(res.isSecondary()) rItem.setSecondary(); if(res.isSpecial()) rItem.setSpecial(); if(res.isStub())
     * rItem.setStub(); if(res.siblings != null && res.siblings.length > 0) { String[] sibStr = new
     * String[res.siblings.length+1]; for(int i = 0; i < res.siblings.length; ++i) sibStr[i] = res.siblings[i];
     * sibStr[sibStr.length - 1] = newKey; res.setSiblings(sibStr); }else { res.setSiblings(newKey); } return rItem; }
     */

}
