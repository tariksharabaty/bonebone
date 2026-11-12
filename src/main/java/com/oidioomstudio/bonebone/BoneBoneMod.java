package com.oidioomstudio.bonebone;

import com.oidioomstudio.bonebone.config.BoneBoneConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoneBoneMod implements ModInitializer {
    public static final String MOD_ID = "bonebone";
    public static final String MOD_NAME = "BoneBone";
    public static final String MOD_VERSION = "1.1.2";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("[BoneBone] Initializing BoneBone mod by Oidioom & Tarek Sharabaty...");
        BoneBoneConfig.load();
        LOGGER.info("[BoneBone] Configuration loaded successfully.");
    }
}
