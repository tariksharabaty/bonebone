package com.oidioomstudio.bonebone.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;

public class BoneBoneConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("bonebone.json");

    // 1. Çimen & Otlar
    public static boolean grassShort = true;
    public static boolean grassTall = true;
    public static boolean grassFern = true;
    public static boolean grassLargeFern = true;
    public static boolean grassShortDry = true;
    public static boolean grassTallDry = true;

    // 2. Çiçekler
    public static boolean flowerDandelion = true;
    public static boolean flowerPoppy = true;
    public static boolean flowerBlueOrchid = true;
    public static boolean flowerAllium = true;
    public static boolean flowerAzureBluet = true;
    public static boolean flowerRedTulip = true;
    public static boolean flowerOrangeTulip = true;
    public static boolean flowerWhiteTulip = true;
    public static boolean flowerPinkTulip = true;
    public static boolean flowerOxeyeDaisy = true;
    public static boolean flowerCornflower = true;
    public static boolean flowerLilyOfTheValley = true;
    public static boolean flowerTorchflower = true;
    public static boolean flowerWitherRose = true;
    public static boolean flowerPinkPetals = true;
    public static boolean flowerOpenEyeblossom = true;
    public static boolean flowerClosedEyeblossom = true;
    public static boolean flowerSunflower = true;
    public static boolean flowerLilac = true;
    public static boolean flowerRoseBush = true;
    public static boolean flowerPeony = true;
    public static boolean flowerPitcherPlant = true;
    public static boolean flowerWildflowers = true;
    public static boolean flowerLeafLitter = true;
    public static boolean flowerCactusFlower = true;

    // 3. Tarım & Ekinler
    public static boolean cropWheat = true;
    public static boolean cropCarrot = true;
    public static boolean cropPotato = true;
    public static boolean cropBeetroot = true;
    public static boolean cropMelon = true;
    public static boolean cropPumpkin = true;
    public static boolean cropTorchflower = true;
    public static boolean cropPitcher = true;
    public static boolean cropCocoa = true;

    // 4. Ağaç Fidanları & Mantarlar
    public static boolean saplingOak = true;
    public static boolean saplingSpruce = true;
    public static boolean saplingBirch = true;
    public static boolean saplingJungle = true;
    public static boolean saplingAcacia = true;
    public static boolean saplingDarkOak = true;
    public static boolean saplingCherry = true;
    public static boolean saplingPaleOak = true;
    public static boolean saplingMangrove = true;
    public static boolean mushroomBrown = true;
    public static boolean mushroomRed = true;
    public static boolean fungusCrimson = true;
    public static boolean fungusWarped = true;
    public static boolean mushroomShelf = true;

    // 5. Doğal Çevre & Flora
    public static boolean floraBamboo = true;
    public static boolean floraSweetBerry = true;
    public static boolean floraFireflyBush = true;
    public static boolean floraCaveVines = true;
    public static boolean floraTwistingVines = true;
    public static boolean floraWeepingVines = true;
    public static boolean floraVine = true;
    public static boolean floraAzalea = true;
    public static boolean floraMoss = true;
    public static boolean floraPaleMoss = true;
    public static boolean floraMossCarpet = true;
    public static boolean floraPaleMossCarpet = true;
    public static boolean floraRootedDirt = true;
    public static boolean floraCrimsonNylium = true;
    public static boolean floraWarpedNylium = true;
    public static boolean floraDripleaf = true;
    public static boolean floraKelp = true;
    public static boolean floraSeagrass = true;
    public static boolean floraSeaPickle = true;
    public static boolean floraGlowLichen = true;

    // 6. Genişletilmiş Kemik Tozu (Ekstra)
    public static boolean extraCactus = false;
    public static boolean extraSugarCane = false;
    public static boolean extraNetherWart = false;

    public static boolean areAllFlowersDisabled() {
        return !flowerDandelion && !flowerPoppy && !flowerBlueOrchid && !flowerAllium
            && !flowerAzureBluet && !flowerRedTulip && !flowerOrangeTulip && !flowerWhiteTulip
            && !flowerPinkTulip && !flowerOxeyeDaisy && !flowerCornflower && !flowerLilyOfTheValley
            && !flowerTorchflower && !flowerWitherRose && !flowerPinkPetals && !flowerOpenEyeblossom
            && !flowerClosedEyeblossom && !flowerSunflower && !flowerLilac && !flowerRoseBush
            && !flowerPeony && !flowerPitcherPlant && !flowerWildflowers && !flowerLeafLitter
            && !flowerCactusFlower;
    }

    public static boolean isFlowerBlock(Block block) {
        return block == Blocks.DANDELION || block == Blocks.POPPY || block == Blocks.BLUE_ORCHID
            || block == Blocks.ALLIUM || block == Blocks.AZURE_BLUET || block == Blocks.RED_TULIP
            || block == Blocks.ORANGE_TULIP || block == Blocks.WHITE_TULIP || block == Blocks.PINK_TULIP
            || block == Blocks.OXEYE_DAISY || block == Blocks.CORNFLOWER || block == Blocks.LILY_OF_THE_VALLEY
            || block == Blocks.TORCHFLOWER || block == Blocks.WITHER_ROSE || block == Blocks.PINK_PETALS
            || block == Blocks.OPEN_EYEBLOSSOM || block == Blocks.CLOSED_EYEBLOSSOM
            || block == Blocks.SUNFLOWER || block == Blocks.LILAC || block == Blocks.ROSE_BUSH
            || block == Blocks.PEONY || block == Blocks.PITCHER_PLANT || block == Blocks.WILDFLOWERS
            || block == Blocks.LEAF_LITTER || block == Blocks.CACTUS_FLOWER;
    }

    public static boolean isFlowerAllowed(Block block) {
        if (block == Blocks.DANDELION) return flowerDandelion;
        if (block == Blocks.POPPY) return flowerPoppy;
        if (block == Blocks.BLUE_ORCHID) return flowerBlueOrchid;
        if (block == Blocks.ALLIUM) return flowerAllium;
        if (block == Blocks.AZURE_BLUET) return flowerAzureBluet;
        if (block == Blocks.RED_TULIP) return flowerRedTulip;
        if (block == Blocks.ORANGE_TULIP) return flowerOrangeTulip;
        if (block == Blocks.WHITE_TULIP) return flowerWhiteTulip;
        if (block == Blocks.PINK_TULIP) return flowerPinkTulip;
        if (block == Blocks.OXEYE_DAISY) return flowerOxeyeDaisy;
        if (block == Blocks.CORNFLOWER) return flowerCornflower;
        if (block == Blocks.LILY_OF_THE_VALLEY) return flowerLilyOfTheValley;
        if (block == Blocks.TORCHFLOWER) return flowerTorchflower;
        if (block == Blocks.WITHER_ROSE) return flowerWitherRose;
        if (block == Blocks.PINK_PETALS) return flowerPinkPetals;
        if (block == Blocks.OPEN_EYEBLOSSOM) return flowerOpenEyeblossom;
        if (block == Blocks.CLOSED_EYEBLOSSOM) return flowerClosedEyeblossom;
        if (block == Blocks.SUNFLOWER) return flowerSunflower;
        if (block == Blocks.LILAC) return flowerLilac;
        if (block == Blocks.ROSE_BUSH) return flowerRoseBush;
        if (block == Blocks.PEONY) return flowerPeony;
        if (block == Blocks.PITCHER_PLANT) return flowerPitcherPlant;
        if (block == Blocks.WILDFLOWERS) return flowerWildflowers;
        if (block == Blocks.LEAF_LITTER) return flowerLeafLitter;
        if (block == Blocks.CACTUS_FLOWER) return flowerCactusFlower;
        return true;
    }

    public static void load() {
        File file = CONFIG_PATH.toFile();
        if (!file.exists()) {
            save();
            return;
        }

        try (FileReader reader = new FileReader(file)) {
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

            // 1
            if (json.has("grassShort")) grassShort = json.get("grassShort").getAsBoolean();
            if (json.has("grassTall")) grassTall = json.get("grassTall").getAsBoolean();
            if (json.has("grassFern")) grassFern = json.get("grassFern").getAsBoolean();
            if (json.has("grassLargeFern")) grassLargeFern = json.get("grassLargeFern").getAsBoolean();
            if (json.has("grassShortDry")) grassShortDry = json.get("grassShortDry").getAsBoolean();
            if (json.has("grassTallDry")) grassTallDry = json.get("grassTallDry").getAsBoolean();

            // 2
            if (json.has("flowerDandelion")) flowerDandelion = json.get("flowerDandelion").getAsBoolean();
            if (json.has("flowerPoppy")) flowerPoppy = json.get("flowerPoppy").getAsBoolean();
            if (json.has("flowerBlueOrchid")) flowerBlueOrchid = json.get("flowerBlueOrchid").getAsBoolean();
            if (json.has("flowerAllium")) flowerAllium = json.get("flowerAllium").getAsBoolean();
            if (json.has("flowerAzureBluet")) flowerAzureBluet = json.get("flowerAzureBluet").getAsBoolean();
            if (json.has("flowerRedTulip")) flowerRedTulip = json.get("flowerRedTulip").getAsBoolean();
            if (json.has("flowerOrangeTulip")) flowerOrangeTulip = json.get("flowerOrangeTulip").getAsBoolean();
            if (json.has("flowerWhiteTulip")) flowerWhiteTulip = json.get("flowerWhiteTulip").getAsBoolean();
            if (json.has("flowerPinkTulip")) flowerPinkTulip = json.get("flowerPinkTulip").getAsBoolean();
            if (json.has("flowerOxeyeDaisy")) flowerOxeyeDaisy = json.get("flowerOxeyeDaisy").getAsBoolean();
            if (json.has("flowerCornflower")) flowerCornflower = json.get("flowerCornflower").getAsBoolean();
            if (json.has("flowerLilyOfTheValley")) flowerLilyOfTheValley = json.get("flowerLilyOfTheValley").getAsBoolean();
            if (json.has("flowerTorchflower")) flowerTorchflower = json.get("flowerTorchflower").getAsBoolean();
            if (json.has("flowerWitherRose")) flowerWitherRose = json.get("flowerWitherRose").getAsBoolean();
            if (json.has("flowerPinkPetals")) flowerPinkPetals = json.get("flowerPinkPetals").getAsBoolean();
            if (json.has("flowerOpenEyeblossom")) flowerOpenEyeblossom = json.get("flowerOpenEyeblossom").getAsBoolean();
            if (json.has("flowerClosedEyeblossom")) flowerClosedEyeblossom = json.get("flowerClosedEyeblossom").getAsBoolean();
            if (json.has("flowerSunflower")) flowerSunflower = json.get("flowerSunflower").getAsBoolean();
            if (json.has("flowerLilac")) flowerLilac = json.get("flowerLilac").getAsBoolean();
            if (json.has("flowerRoseBush")) flowerRoseBush = json.get("flowerRoseBush").getAsBoolean();
            if (json.has("flowerPeony")) flowerPeony = json.get("flowerPeony").getAsBoolean();
            if (json.has("flowerPitcherPlant")) flowerPitcherPlant = json.get("flowerPitcherPlant").getAsBoolean();
            if (json.has("flowerWildflowers")) flowerWildflowers = json.get("flowerWildflowers").getAsBoolean();
            if (json.has("flowerLeafLitter")) flowerLeafLitter = json.get("flowerLeafLitter").getAsBoolean();
            if (json.has("flowerCactusFlower")) flowerCactusFlower = json.get("flowerCactusFlower").getAsBoolean();

            // 3
            if (json.has("cropWheat")) cropWheat = json.get("cropWheat").getAsBoolean();
            if (json.has("cropCarrot")) cropCarrot = json.get("cropCarrot").getAsBoolean();
            if (json.has("cropPotato")) cropPotato = json.get("cropPotato").getAsBoolean();
            if (json.has("cropBeetroot")) cropBeetroot = json.get("cropBeetroot").getAsBoolean();
            if (json.has("cropMelon")) cropMelon = json.get("cropMelon").getAsBoolean();
            if (json.has("cropPumpkin")) cropPumpkin = json.get("cropPumpkin").getAsBoolean();
            if (json.has("cropTorchflower")) cropTorchflower = json.get("cropTorchflower").getAsBoolean();
            if (json.has("cropPitcher")) cropPitcher = json.get("cropPitcher").getAsBoolean();
            if (json.has("cropCocoa")) cropCocoa = json.get("cropCocoa").getAsBoolean();

            // 4
            if (json.has("saplingOak")) saplingOak = json.get("saplingOak").getAsBoolean();
            if (json.has("saplingSpruce")) saplingSpruce = json.get("saplingSpruce").getAsBoolean();
            if (json.has("saplingBirch")) saplingBirch = json.get("saplingBirch").getAsBoolean();
            if (json.has("saplingJungle")) saplingJungle = json.get("saplingJungle").getAsBoolean();
            if (json.has("saplingAcacia")) saplingAcacia = json.get("saplingAcacia").getAsBoolean();
            if (json.has("saplingDarkOak")) saplingDarkOak = json.get("saplingDarkOak").getAsBoolean();
            if (json.has("saplingCherry")) saplingCherry = json.get("saplingCherry").getAsBoolean();
            if (json.has("saplingPaleOak")) saplingPaleOak = json.get("saplingPaleOak").getAsBoolean();
            if (json.has("saplingMangrove")) saplingMangrove = json.get("saplingMangrove").getAsBoolean();
            if (json.has("mushroomBrown")) mushroomBrown = json.get("mushroomBrown").getAsBoolean();
            if (json.has("mushroomRed")) mushroomRed = json.get("mushroomRed").getAsBoolean();
            if (json.has("fungusCrimson")) fungusCrimson = json.get("fungusCrimson").getAsBoolean();
            if (json.has("fungusWarped")) fungusWarped = json.get("fungusWarped").getAsBoolean();
            if (json.has("mushroomShelf")) mushroomShelf = json.get("mushroomShelf").getAsBoolean();

            // 5
            if (json.has("floraBamboo")) floraBamboo = json.get("floraBamboo").getAsBoolean();
            if (json.has("floraSweetBerry")) floraSweetBerry = json.get("floraSweetBerry").getAsBoolean();
            if (json.has("floraFireflyBush")) floraFireflyBush = json.get("floraFireflyBush").getAsBoolean();
            if (json.has("floraCaveVines")) floraCaveVines = json.get("floraCaveVines").getAsBoolean();
            if (json.has("floraTwistingVines")) floraTwistingVines = json.get("floraTwistingVines").getAsBoolean();
            if (json.has("floraWeepingVines")) floraWeepingVines = json.get("floraWeepingVines").getAsBoolean();
            if (json.has("floraVine")) floraVine = json.get("floraVine").getAsBoolean();
            if (json.has("floraAzalea")) floraAzalea = json.get("floraAzalea").getAsBoolean();
            if (json.has("floraMoss")) floraMoss = json.get("floraMoss").getAsBoolean();
            if (json.has("floraPaleMoss")) floraPaleMoss = json.get("floraPaleMoss").getAsBoolean();
            if (json.has("floraMossCarpet")) floraMossCarpet = json.get("floraMossCarpet").getAsBoolean();
            if (json.has("floraPaleMossCarpet")) floraPaleMossCarpet = json.get("floraPaleMossCarpet").getAsBoolean();
            if (json.has("floraRootedDirt")) floraRootedDirt = json.get("floraRootedDirt").getAsBoolean();
            if (json.has("floraCrimsonNylium")) floraCrimsonNylium = json.get("floraCrimsonNylium").getAsBoolean();
            if (json.has("floraWarpedNylium")) floraWarpedNylium = json.get("floraWarpedNylium").getAsBoolean();
            if (json.has("floraDripleaf")) floraDripleaf = json.get("floraDripleaf").getAsBoolean();
            if (json.has("floraKelp")) floraKelp = json.get("floraKelp").getAsBoolean();
            if (json.has("floraSeagrass")) floraSeagrass = json.get("floraSeagrass").getAsBoolean();
            if (json.has("floraSeaPickle")) floraSeaPickle = json.get("floraSeaPickle").getAsBoolean();
            if (json.has("floraGlowLichen")) floraGlowLichen = json.get("floraGlowLichen").getAsBoolean();

            // 6
            if (json.has("extraCactus")) extraCactus = json.get("extraCactus").getAsBoolean();
            if (json.has("extraSugarCane")) extraSugarCane = json.get("extraSugarCane").getAsBoolean();
            if (json.has("extraNetherWart")) extraNetherWart = json.get("extraNetherWart").getAsBoolean();

            save();
        } catch (Exception e) {
            e.printStackTrace();
            save();
        }
    }

    public static void save() {
        try {
            File file = CONFIG_PATH.toFile();
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            JsonObject json = new JsonObject();

            // 1
            json.addProperty("grassShort", grassShort);
            json.addProperty("grassTall", grassTall);
            json.addProperty("grassFern", grassFern);
            json.addProperty("grassLargeFern", grassLargeFern);
            json.addProperty("grassShortDry", grassShortDry);
            json.addProperty("grassTallDry", grassTallDry);

            // 2
            json.addProperty("flowerDandelion", flowerDandelion);
            json.addProperty("flowerPoppy", flowerPoppy);
            json.addProperty("flowerBlueOrchid", flowerBlueOrchid);
            json.addProperty("flowerAllium", flowerAllium);
            json.addProperty("flowerAzureBluet", flowerAzureBluet);
            json.addProperty("flowerRedTulip", flowerRedTulip);
            json.addProperty("flowerOrangeTulip", flowerOrangeTulip);
            json.addProperty("flowerWhiteTulip", flowerWhiteTulip);
            json.addProperty("flowerPinkTulip", flowerPinkTulip);
            json.addProperty("flowerOxeyeDaisy", flowerOxeyeDaisy);
            json.addProperty("flowerCornflower", flowerCornflower);
            json.addProperty("flowerLilyOfTheValley", flowerLilyOfTheValley);
            json.addProperty("flowerTorchflower", flowerTorchflower);
            json.addProperty("flowerWitherRose", flowerWitherRose);
            json.addProperty("flowerPinkPetals", flowerPinkPetals);
            json.addProperty("flowerOpenEyeblossom", flowerOpenEyeblossom);
            json.addProperty("flowerClosedEyeblossom", flowerClosedEyeblossom);
            json.addProperty("flowerSunflower", flowerSunflower);
            json.addProperty("flowerLilac", flowerLilac);
            json.addProperty("flowerRoseBush", flowerRoseBush);
            json.addProperty("flowerPeony", flowerPeony);
            json.addProperty("flowerPitcherPlant", flowerPitcherPlant);
            json.addProperty("flowerWildflowers", flowerWildflowers);
            json.addProperty("flowerLeafLitter", flowerLeafLitter);
            json.addProperty("flowerCactusFlower", flowerCactusFlower);

            // 3
            json.addProperty("cropWheat", cropWheat);
            json.addProperty("cropCarrot", cropCarrot);
            json.addProperty("cropPotato", cropPotato);
            json.addProperty("cropBeetroot", cropBeetroot);
            json.addProperty("cropMelon", cropMelon);
            json.addProperty("cropPumpkin", cropPumpkin);
            json.addProperty("cropTorchflower", cropTorchflower);
            json.addProperty("cropPitcher", cropPitcher);
            json.addProperty("cropCocoa", cropCocoa);

            // 4
            json.addProperty("saplingOak", saplingOak);
            json.addProperty("saplingSpruce", saplingSpruce);
            json.addProperty("saplingBirch", saplingBirch);
            json.addProperty("saplingJungle", saplingJungle);
            json.addProperty("saplingAcacia", saplingAcacia);
            json.addProperty("saplingDarkOak", saplingDarkOak);
            json.addProperty("saplingCherry", saplingCherry);
            json.addProperty("saplingPaleOak", saplingPaleOak);
            json.addProperty("saplingMangrove", saplingMangrove);
            json.addProperty("mushroomBrown", mushroomBrown);
            json.addProperty("mushroomRed", mushroomRed);
            json.addProperty("fungusCrimson", fungusCrimson);
            json.addProperty("fungusWarped", fungusWarped);
            json.addProperty("mushroomShelf", mushroomShelf);

            // 5
            json.addProperty("floraBamboo", floraBamboo);
            json.addProperty("floraSweetBerry", floraSweetBerry);
            json.addProperty("floraFireflyBush", floraFireflyBush);
            json.addProperty("floraCaveVines", floraCaveVines);
            json.addProperty("floraTwistingVines", floraTwistingVines);
            json.addProperty("floraWeepingVines", floraWeepingVines);
            json.addProperty("floraVine", floraVine);
            json.addProperty("floraAzalea", floraAzalea);
            json.addProperty("floraMoss", floraMoss);
            json.addProperty("floraPaleMoss", floraPaleMoss);
            json.addProperty("floraMossCarpet", floraMossCarpet);
            json.addProperty("floraPaleMossCarpet", floraPaleMossCarpet);
            json.addProperty("floraRootedDirt", floraRootedDirt);
            json.addProperty("floraCrimsonNylium", floraCrimsonNylium);
            json.addProperty("floraWarpedNylium", floraWarpedNylium);
            json.addProperty("floraDripleaf", floraDripleaf);
            json.addProperty("floraKelp", floraKelp);
            json.addProperty("floraSeagrass", floraSeagrass);
            json.addProperty("floraSeaPickle", floraSeaPickle);
            json.addProperty("floraGlowLichen", floraGlowLichen);

            // 6
            json.addProperty("extraCactus", extraCactus);
            json.addProperty("extraSugarCane", extraSugarCane);
            json.addProperty("extraNetherWart", extraNetherWart);

            try (FileWriter writer = new FileWriter(file)) {
                GSON.toJson(json, writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAllFlowers(boolean enabled) {
        flowerDandelion = enabled;
        flowerPoppy = enabled;
        flowerBlueOrchid = enabled;
        flowerAllium = enabled;
        flowerAzureBluet = enabled;
        flowerRedTulip = enabled;
        flowerOrangeTulip = enabled;
        flowerWhiteTulip = enabled;
        flowerPinkTulip = enabled;
        flowerOxeyeDaisy = enabled;
        flowerCornflower = enabled;
        flowerLilyOfTheValley = enabled;
        flowerTorchflower = enabled;
        flowerWitherRose = enabled;
        flowerPinkPetals = enabled;
        flowerOpenEyeblossom = enabled;
        flowerClosedEyeblossom = enabled;
        flowerSunflower = enabled;
        flowerLilac = enabled;
        flowerRoseBush = enabled;
        flowerPeony = enabled;
        flowerPitcherPlant = enabled;
        flowerWildflowers = enabled;
        flowerLeafLitter = enabled;
        flowerCactusFlower = enabled;
    }

    public static void resetDefaults() {
        grassShort = true;
        grassTall = true;
        grassFern = true;
        grassLargeFern = true;
        grassShortDry = true;
        grassTallDry = true;

        setAllFlowers(true);

        cropWheat = true;
        cropCarrot = true;
        cropPotato = true;
        cropBeetroot = true;
        cropMelon = true;
        cropPumpkin = true;
        cropTorchflower = true;
        cropPitcher = true;
        cropCocoa = true;

        saplingOak = true;
        saplingSpruce = true;
        saplingBirch = true;
        saplingJungle = true;
        saplingAcacia = true;
        saplingDarkOak = true;
        saplingCherry = true;
        saplingPaleOak = true;
        saplingMangrove = true;
        mushroomBrown = true;
        mushroomRed = true;
        fungusCrimson = true;
        fungusWarped = true;
        mushroomShelf = true;

        floraBamboo = true;
        floraSweetBerry = true;
        floraFireflyBush = true;
        floraCaveVines = true;
        floraTwistingVines = true;
        floraWeepingVines = true;
        floraVine = true;
        floraAzalea = true;
        floraMoss = true;
        floraPaleMoss = true;
        floraMossCarpet = true;
        floraPaleMossCarpet = true;
        floraRootedDirt = true;
        floraCrimsonNylium = true;
        floraWarpedNylium = true;
        floraDripleaf = true;
        floraKelp = true;
        floraSeagrass = true;
        floraSeaPickle = true;
        floraGlowLichen = true;

        extraCactus = false;
        extraSugarCane = false;
        extraNetherWart = false;

        save();
    }
}
