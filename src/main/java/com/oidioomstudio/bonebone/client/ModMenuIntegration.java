package com.oidioomstudio.bonebone.client;

import com.oidioomstudio.bonebone.BoneBoneMod;
import com.oidioomstudio.olib.client.OModMenuApi;

public class ModMenuIntegration extends OModMenuApi {
    @Override
    protected String getModId() {
        return BoneBoneMod.MOD_ID;
    }
}
