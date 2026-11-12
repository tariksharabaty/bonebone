package com.oidioomstudio.bonebone.client;

import com.oidioomstudio.bonebone.BoneBoneMod;
import com.oidioomstudio.bonebone.config.BoneBoneConfig;
import com.oidioomstudio.olib.api.OConfigCategory;
import com.oidioomstudio.olib.api.OConfigRegistry;
import com.oidioomstudio.olib.api.OModConfig;
import com.oidioomstudio.olib.api.options.BooleanOption;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BoneBoneClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerConfig();
    }

    public static void registerConfig() {
        OConfigRegistry.register(
            OModConfig.builder("bonebone", Component.translatable("bonebone.name"), BoneBoneMod.MOD_VERSION)
                // 1. Bitkiler & Çiçekler (Plants & Flowers) Tab
                .category(OConfigCategory.builder("plants", Component.translatable("bonebone.tab.plants"))
                    // Grup 1: Çimen & Otlar
                    .group("grass", Component.translatable("bonebone.group.grass"), g -> g
                        .description(Component.translatable("bonebone.group.grass.desc"))
                        .add(boolOpt("grass_short", "grass_short", Items.SHORT_GRASS, () -> BoneBoneConfig.grassShort, v -> BoneBoneConfig.grassShort = v))
                        .add(boolOpt("grass_tall", "grass_tall", Items.TALL_GRASS, () -> BoneBoneConfig.grassTall, v -> BoneBoneConfig.grassTall = v))
                        .add(boolOpt("grass_fern", "grass_fern", Items.FERN, () -> BoneBoneConfig.grassFern, v -> BoneBoneConfig.grassFern = v))
                        .add(boolOpt("grass_large_fern", "grass_large_fern", Items.LARGE_FERN, () -> BoneBoneConfig.grassLargeFern, v -> BoneBoneConfig.grassLargeFern = v))
                        .add(boolOpt("grass_short_dry", "grass_short_dry", Items.DRY_SHORT_GRASS, () -> BoneBoneConfig.grassShortDry, v -> BoneBoneConfig.grassShortDry = v))
                        .add(boolOpt("grass_tall_dry", "grass_tall_dry", Items.DRY_TALL_GRASS, () -> BoneBoneConfig.grassTallDry, v -> BoneBoneConfig.grassTallDry = v))
                    )
                    // Grup 2: Küçük Çiçekler
                    .group("flowers_small", Component.translatable("bonebone.group.flowers_small"), g -> g
                        .description(Component.translatable("bonebone.group.flowers_small.desc"))
                        .add(boolOpt("flower_dandelion", "flower_dandelion", Items.DANDELION, () -> BoneBoneConfig.flowerDandelion, v -> BoneBoneConfig.flowerDandelion = v))
                        .add(boolOpt("flower_poppy", "flower_poppy", Items.POPPY, () -> BoneBoneConfig.flowerPoppy, v -> BoneBoneConfig.flowerPoppy = v))
                        .add(boolOpt("flower_blue_orchid", "flower_blue_orchid", Items.BLUE_ORCHID, () -> BoneBoneConfig.flowerBlueOrchid, v -> BoneBoneConfig.flowerBlueOrchid = v))
                        .add(boolOpt("flower_allium", "flower_allium", Items.ALLIUM, () -> BoneBoneConfig.flowerAllium, v -> BoneBoneConfig.flowerAllium = v))
                        .add(boolOpt("flower_azure_bluet", "flower_azure_bluet", Items.AZURE_BLUET, () -> BoneBoneConfig.flowerAzureBluet, v -> BoneBoneConfig.flowerAzureBluet = v))
                        .add(boolOpt("flower_red_tulip", "flower_red_tulip", Items.RED_TULIP, () -> BoneBoneConfig.flowerRedTulip, v -> BoneBoneConfig.flowerRedTulip = v))
                        .add(boolOpt("flower_orange_tulip", "flower_orange_tulip", Items.ORANGE_TULIP, () -> BoneBoneConfig.flowerOrangeTulip, v -> BoneBoneConfig.flowerOrangeTulip = v))
                        .add(boolOpt("flower_white_tulip", "flower_white_tulip", Items.WHITE_TULIP, () -> BoneBoneConfig.flowerWhiteTulip, v -> BoneBoneConfig.flowerWhiteTulip = v))
                        .add(boolOpt("flower_pink_tulip", "flower_pink_tulip", Items.PINK_TULIP, () -> BoneBoneConfig.flowerPinkTulip, v -> BoneBoneConfig.flowerPinkTulip = v))
                        .add(boolOpt("flower_oxeye_daisy", "flower_oxeye_daisy", Items.OXEYE_DAISY, () -> BoneBoneConfig.flowerOxeyeDaisy, v -> BoneBoneConfig.flowerOxeyeDaisy = v))
                        .add(boolOpt("flower_cornflower", "flower_cornflower", Items.CORNFLOWER, () -> BoneBoneConfig.flowerCornflower, v -> BoneBoneConfig.flowerCornflower = v))
                        .add(boolOpt("flower_lily_of_the_valley", "flower_lily_of_the_valley", Items.LILY_OF_THE_VALLEY, () -> BoneBoneConfig.flowerLilyOfTheValley, v -> BoneBoneConfig.flowerLilyOfTheValley = v))
                    )
                    // Grup 3: Büyük Çiçekler
                    .group("flowers_tall", Component.translatable("bonebone.group.flowers_tall"), g -> g
                        .description(Component.translatable("bonebone.group.flowers_tall.desc"))
                        .add(boolOpt("flower_sunflower", "flower_sunflower", Items.SUNFLOWER, () -> BoneBoneConfig.flowerSunflower, v -> BoneBoneConfig.flowerSunflower = v))
                        .add(boolOpt("flower_lilac", "flower_lilac", Items.LILAC, () -> BoneBoneConfig.flowerLilac, v -> BoneBoneConfig.flowerLilac = v))
                        .add(boolOpt("flower_rose_bush", "flower_rose_bush", Items.ROSE_BUSH, () -> BoneBoneConfig.flowerRoseBush, v -> BoneBoneConfig.flowerRoseBush = v))
                        .add(boolOpt("flower_peony", "flower_peony", Items.PEONY, () -> BoneBoneConfig.flowerPeony, v -> BoneBoneConfig.flowerPeony = v))
                        .add(boolOpt("flower_pitcher_plant", "flower_pitcher_plant", Items.PITCHER_PLANT, () -> BoneBoneConfig.flowerPitcherPlant, v -> BoneBoneConfig.flowerPitcherPlant = v))
                    )
                    // Grup 4: Soluk Bahçe & Özel
                    .group("flowers_special", Component.translatable("bonebone.group.flowers_special"), g -> g
                        .description(Component.translatable("bonebone.group.flowers_special.desc"))
                        .add(boolOpt("flower_open_eyeblossom", "flower_open_eyeblossom", Items.OPEN_EYEBLOSSOM, () -> BoneBoneConfig.flowerOpenEyeblossom, v -> BoneBoneConfig.flowerOpenEyeblossom = v))
                        .add(boolOpt("flower_closed_eyeblossom", "flower_closed_eyeblossom", Items.CLOSED_EYEBLOSSOM, () -> BoneBoneConfig.flowerClosedEyeblossom, v -> BoneBoneConfig.flowerClosedEyeblossom = v))
                        .add(boolOpt("flower_pink_petals", "flower_pink_petals", Items.PINK_PETALS, () -> BoneBoneConfig.flowerPinkPetals, v -> BoneBoneConfig.flowerPinkPetals = v))
                        .add(boolOpt("flower_wildflowers", "flower_wildflowers", Items.WILDFLOWERS, () -> BoneBoneConfig.flowerWildflowers, v -> BoneBoneConfig.flowerWildflowers = v))
                        .add(boolOpt("flower_leaf_litter", "flower_leaf_litter", Items.LEAF_LITTER, () -> BoneBoneConfig.flowerLeafLitter, v -> BoneBoneConfig.flowerLeafLitter = v))
                        .add(boolOpt("flower_cactus_flower", "flower_cactus_flower", Items.CACTUS_FLOWER, () -> BoneBoneConfig.flowerCactusFlower, v -> BoneBoneConfig.flowerCactusFlower = v))
                    )
                    .build())

                // 2. Tarım & Fidanlar (Agriculture & Saplings) Tab
                .category(OConfigCategory.builder("crops", Component.translatable("bonebone.tab.crops"))
                    // Grup 1: Ekinler & Tarım
                    .group("crops", Component.translatable("bonebone.group.crops"), g -> g
                        .description(Component.translatable("bonebone.group.crops.desc"))
                        .add(boolOpt("crop_wheat", "crop_wheat", Items.WHEAT, () -> BoneBoneConfig.cropWheat, v -> BoneBoneConfig.cropWheat = v))
                        .add(boolOpt("crop_carrot", "crop_carrot", Items.CARROT, () -> BoneBoneConfig.cropCarrot, v -> BoneBoneConfig.cropCarrot = v))
                        .add(boolOpt("crop_potato", "crop_potato", Items.POTATO, () -> BoneBoneConfig.cropPotato, v -> BoneBoneConfig.cropPotato = v))
                        .add(boolOpt("crop_beetroot", "crop_beetroot", Items.BEETROOT, () -> BoneBoneConfig.cropBeetroot, v -> BoneBoneConfig.cropBeetroot = v))
                        .add(boolOpt("crop_melon", "crop_melon", Items.MELON_SLICE, () -> BoneBoneConfig.cropMelon, v -> BoneBoneConfig.cropMelon = v))
                        .add(boolOpt("crop_pumpkin", "crop_pumpkin", Items.PUMPKIN, () -> BoneBoneConfig.cropPumpkin, v -> BoneBoneConfig.cropPumpkin = v))
                        .add(boolOpt("crop_torchflower", "crop_torchflower", Items.TORCHFLOWER_SEEDS, () -> BoneBoneConfig.cropTorchflower, v -> BoneBoneConfig.cropTorchflower = v))
                        .add(boolOpt("crop_pitcher", "crop_pitcher", Items.PITCHER_POD, () -> BoneBoneConfig.cropPitcher, v -> BoneBoneConfig.cropPitcher = v))
                        .add(boolOpt("crop_cocoa", "crop_cocoa", Items.COCOA_BEANS, () -> BoneBoneConfig.cropCocoa, v -> BoneBoneConfig.cropCocoa = v))
                    )
                    // Grup 2: Ağaç Fidanları
                    .group("saplings", Component.translatable("bonebone.group.saplings"), g -> g
                        .description(Component.translatable("bonebone.group.saplings.desc"))
                        .add(boolOpt("sapling_oak", "sapling_oak", Items.OAK_SAPLING, () -> BoneBoneConfig.saplingOak, v -> BoneBoneConfig.saplingOak = v))
                        .add(boolOpt("sapling_spruce", "sapling_spruce", Items.SPRUCE_SAPLING, () -> BoneBoneConfig.saplingSpruce, v -> BoneBoneConfig.saplingSpruce = v))
                        .add(boolOpt("sapling_birch", "sapling_birch", Items.BIRCH_SAPLING, () -> BoneBoneConfig.saplingBirch, v -> BoneBoneConfig.saplingBirch = v))
                        .add(boolOpt("sapling_jungle", "sapling_jungle", Items.JUNGLE_SAPLING, () -> BoneBoneConfig.saplingJungle, v -> BoneBoneConfig.saplingJungle = v))
                        .add(boolOpt("sapling_acacia", "sapling_acacia", Items.ACACIA_SAPLING, () -> BoneBoneConfig.saplingAcacia, v -> BoneBoneConfig.saplingAcacia = v))
                        .add(boolOpt("sapling_dark_oak", "sapling_dark_oak", Items.DARK_OAK_SAPLING, () -> BoneBoneConfig.saplingDarkOak, v -> BoneBoneConfig.saplingDarkOak = v))
                        .add(boolOpt("sapling_cherry", "sapling_cherry", Items.CHERRY_SAPLING, () -> BoneBoneConfig.saplingCherry, v -> BoneBoneConfig.saplingCherry = v))
                        .add(boolOpt("sapling_pale_oak", "sapling_pale_oak", Items.PALE_OAK_SAPLING, () -> BoneBoneConfig.saplingPaleOak, v -> BoneBoneConfig.saplingPaleOak = v))
                        .add(boolOpt("sapling_mangrove", "sapling_mangrove", Items.MANGROVE_PROPAGULE, () -> BoneBoneConfig.saplingMangrove, v -> BoneBoneConfig.saplingMangrove = v))
                    )
                    // Grup 3: Mantarlar & Funguslar
                    .group("mushrooms", Component.translatable("bonebone.group.mushrooms"), g -> g
                        .description(Component.translatable("bonebone.group.mushrooms.desc"))
                        .add(boolOpt("mushroom_brown", "mushroom_brown", Items.BROWN_MUSHROOM, () -> BoneBoneConfig.mushroomBrown, v -> BoneBoneConfig.mushroomBrown = v))
                        .add(boolOpt("mushroom_red", "mushroom_red", Items.RED_MUSHROOM, () -> BoneBoneConfig.mushroomRed, v -> BoneBoneConfig.mushroomRed = v))
                        .add(boolOpt("fungus_crimson", "fungus_crimson", Items.CRIMSON_FUNGUS, () -> BoneBoneConfig.fungusCrimson, v -> BoneBoneConfig.fungusCrimson = v))
                        .add(boolOpt("fungus_warped", "fungus_warped", Items.WARPED_FUNGUS, () -> BoneBoneConfig.fungusWarped, v -> BoneBoneConfig.fungusWarped = v))
                        .add(boolOpt("mushroom_shelf", "mushroom_shelf", Items.SHELF_MUSHROOM, () -> BoneBoneConfig.mushroomShelf, v -> BoneBoneConfig.mushroomShelf = v))
                    )
                    .build())

                // 3. Botanik (Botany) Tab
                .category(OConfigCategory.builder("flora", Component.translatable("bonebone.tab.flora"))
                    // Grup 1: Sarmaşıklar & Tırmanıcılar
                    .group("vines", Component.translatable("bonebone.group.vines"), g -> g
                        .description(Component.translatable("bonebone.group.vines.desc"))
                        .add(boolOpt("flora_cave_vines", "flora_cave_vines", Items.GLOW_BERRIES, () -> BoneBoneConfig.floraCaveVines, v -> BoneBoneConfig.floraCaveVines = v))
                        .add(boolOpt("flora_twisting_vines", "flora_twisting_vines", Items.TWISTING_VINES, () -> BoneBoneConfig.floraTwistingVines, v -> BoneBoneConfig.floraTwistingVines = v))
                        .add(boolOpt("flora_weeping_vines", "flora_weeping_vines", Items.WEEPING_VINES, () -> BoneBoneConfig.floraWeepingVines, v -> BoneBoneConfig.floraWeepingVines = v))
                        .add(boolOpt("flora_vine", "flora_vine", Items.VINE, () -> BoneBoneConfig.floraVine, v -> BoneBoneConfig.floraVine = v))
                    )
                    // Grup 2: Bitki Örtüsü & Yosunlar
                    .group("bushes", Component.translatable("bonebone.group.bushes"), g -> g
                        .description(Component.translatable("bonebone.group.bushes.desc"))
                        .add(boolOpt("flora_bamboo", "flora_bamboo", Items.BAMBOO, () -> BoneBoneConfig.floraBamboo, v -> BoneBoneConfig.floraBamboo = v))
                        .add(boolOpt("flora_sweet_berries", "flora_sweet_berries", Items.SWEET_BERRIES, () -> BoneBoneConfig.floraSweetBerry, v -> BoneBoneConfig.floraSweetBerry = v))
                        .add(boolOpt("flora_firefly_bush", "flora_firefly_bush", Items.FIREFLY_BUSH, () -> BoneBoneConfig.floraFireflyBush, v -> BoneBoneConfig.floraFireflyBush = v))
                        .add(boolOpt("flora_azalea", "flora_azalea", Items.AZALEA, () -> BoneBoneConfig.floraAzalea, v -> BoneBoneConfig.floraAzalea = v))
                        .add(boolOpt("flora_moss", "flora_moss", Items.MOSS_BLOCK, () -> BoneBoneConfig.floraMoss, v -> BoneBoneConfig.floraMoss = v))
                        .add(boolOpt("flora_pale_moss", "flora_pale_moss", Items.PALE_MOSS_BLOCK, () -> BoneBoneConfig.floraPaleMoss, v -> BoneBoneConfig.floraPaleMoss = v))
                        .add(boolOpt("flora_moss_carpet", "flora_moss_carpet", Items.MOSS_CARPET, () -> BoneBoneConfig.floraMossCarpet, v -> BoneBoneConfig.floraMossCarpet = v))
                        .add(boolOpt("flora_pale_moss_carpet", "flora_pale_moss_carpet", Items.PALE_MOSS_CARPET, () -> BoneBoneConfig.floraPaleMossCarpet, v -> BoneBoneConfig.floraPaleMossCarpet = v))
                        .add(boolOpt("flora_rooted_dirt", "flora_rooted_dirt", Items.ROOTED_DIRT, () -> BoneBoneConfig.floraRootedDirt, v -> BoneBoneConfig.floraRootedDirt = v))
                        .add(boolOpt("flora_crimson_nylium", "flora_crimson_nylium", Items.CRIMSON_NYLIUM, () -> BoneBoneConfig.floraCrimsonNylium, v -> BoneBoneConfig.floraCrimsonNylium = v))
                        .add(boolOpt("flora_warped_nylium", "flora_warped_nylium", Items.WARPED_NYLIUM, () -> BoneBoneConfig.floraWarpedNylium, v -> BoneBoneConfig.floraWarpedNylium = v))
                        .add(boolOpt("flora_dripleaf", "flora_dripleaf", Items.BIG_DRIPLEAF, () -> BoneBoneConfig.floraDripleaf, v -> BoneBoneConfig.floraDripleaf = v))
                        .add(boolOpt("flora_glow_lichen", "flora_glow_lichen", Items.GLOW_LICHEN, () -> BoneBoneConfig.floraGlowLichen, v -> BoneBoneConfig.floraGlowLichen = v))
                    )
                    // Grup 3: Su Altı Florası
                    .group("marine", Component.translatable("bonebone.group.marine"), g -> g
                        .description(Component.translatable("bonebone.group.marine.desc"))
                        .add(boolOpt("flora_kelp", "flora_kelp", Items.KELP, () -> BoneBoneConfig.floraKelp, v -> BoneBoneConfig.floraKelp = v))
                        .add(boolOpt("flora_seagrass", "flora_seagrass", Items.SEAGRASS, () -> BoneBoneConfig.floraSeagrass, v -> BoneBoneConfig.floraSeagrass = v))
                        .add(boolOpt("flora_sea_pickle", "flora_sea_pickle", Items.SEA_PICKLE, () -> BoneBoneConfig.floraSeaPickle, v -> BoneBoneConfig.floraSeaPickle = v))
                    )
                    .build())

                // 4. Ekstra (Extra) Tab
                .category(OConfigCategory.builder("extra", Component.translatable("bonebone.tab.extra"))
                    // Grup 1: Ekstra Mekanikler
                    .group("extra", Component.translatable("bonebone.group.extra"), g -> g
                        .description(Component.translatable("bonebone.group.extra.desc"))
                        .add(boolOpt("extra_cactus", "extra_cactus", Items.CACTUS, () -> BoneBoneConfig.extraCactus, v -> BoneBoneConfig.extraCactus = v, false))
                        .add(boolOpt("extra_sugar_cane", "extra_sugar_cane", Items.SUGAR_CANE, () -> BoneBoneConfig.extraSugarCane, v -> BoneBoneConfig.extraSugarCane = v, false))
                        .add(boolOpt("extra_nether_wart", "extra_nether_wart", Items.NETHER_WART, () -> BoneBoneConfig.extraNetherWart, v -> BoneBoneConfig.extraNetherWart = v, false))
                    )
                    .build())
                .onSave(BoneBoneConfig::save)
                .onResetAll(BoneBoneConfig::resetDefaults)
                .build()
        );
    }

    private static BooleanOption boolOpt(String id, String langKey, Item iconItem, Supplier<Boolean> getter, Consumer<Boolean> setter) {
        return boolOpt(id, langKey, iconItem, getter, setter, true);
    }

    private static BooleanOption boolOpt(String id, String langKey, Item iconItem, Supplier<Boolean> getter, Consumer<Boolean> setter, boolean defaultVal) {
        return BooleanOption.builder(id, Component.translatable("bonebone.option." + langKey))
            .description(Component.translatable("bonebone.option." + langKey + ".desc"))
            .icon(iconItem)
            .defaultValue(defaultVal)
            .getter(getter)
            .setter(setter)
            .build();
    }
}
