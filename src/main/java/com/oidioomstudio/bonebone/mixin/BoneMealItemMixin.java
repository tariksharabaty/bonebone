package com.oidioomstudio.bonebone.mixin;

import com.oidioomstudio.bonebone.config.BoneBoneConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoneMealItem.class)
public class BoneMealItemMixin {

    @Inject(method = "growCrop", at = @At("HEAD"), cancellable = true)
    private static void onGrowCrop(ItemStack itemStack, Level level, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = level.getBlockState(blockPos);
        Block block = state.getBlock();

        // 1. Ekinler (Crops)
        if (state.is(Blocks.WHEAT) && !BoneBoneConfig.cropWheat) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.CARROTS) && !BoneBoneConfig.cropCarrot) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.POTATOES) && !BoneBoneConfig.cropPotato) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.BEETROOTS) && !BoneBoneConfig.cropBeetroot) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.MELON_STEM) || state.is(Blocks.ATTACHED_MELON_STEM)) && !BoneBoneConfig.cropMelon) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.PUMPKIN_STEM) || state.is(Blocks.ATTACHED_PUMPKIN_STEM)) && !BoneBoneConfig.cropPumpkin) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.TORCHFLOWER_CROP) && !BoneBoneConfig.cropTorchflower) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.PITCHER_CROP) && !BoneBoneConfig.cropPitcher) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.COCOA) && !BoneBoneConfig.cropCocoa) { cir.setReturnValue(false); return; }

        // 2. Ağaç Fidanları & Mantarlar
        if (state.is(Blocks.OAK_SAPLING) && !BoneBoneConfig.saplingOak) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.SPRUCE_SAPLING) && !BoneBoneConfig.saplingSpruce) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.BIRCH_SAPLING) && !BoneBoneConfig.saplingBirch) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.JUNGLE_SAPLING) && !BoneBoneConfig.saplingJungle) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.ACACIA_SAPLING) && !BoneBoneConfig.saplingAcacia) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.DARK_OAK_SAPLING) && !BoneBoneConfig.saplingDarkOak) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.CHERRY_SAPLING) && !BoneBoneConfig.saplingCherry) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.PALE_OAK_SAPLING) && !BoneBoneConfig.saplingPaleOak) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.MANGROVE_PROPAGULE) || state.is(Blocks.MANGROVE_LEAVES)) && !BoneBoneConfig.saplingMangrove) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.BROWN_MUSHROOM) && !BoneBoneConfig.mushroomBrown) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.RED_MUSHROOM) && !BoneBoneConfig.mushroomRed) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.CRIMSON_FUNGUS) && !BoneBoneConfig.fungusCrimson) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.WARPED_FUNGUS) && !BoneBoneConfig.fungusWarped) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.SHELF_MUSHROOM) && !BoneBoneConfig.mushroomShelf) { cir.setReturnValue(false); return; }

        // 3. Özel Flora
        if ((state.is(Blocks.BAMBOO) || state.is(Blocks.BAMBOO_SAPLING)) && !BoneBoneConfig.floraBamboo) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.SWEET_BERRY_BUSH) && !BoneBoneConfig.floraSweetBerry) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.FIREFLY_BUSH) && !BoneBoneConfig.floraFireflyBush) { cir.setReturnValue(false); return; }
        if (block instanceof CaveVines && !BoneBoneConfig.floraCaveVines) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.TWISTING_VINES) || state.is(Blocks.TWISTING_VINES_PLANT)) && !BoneBoneConfig.floraTwistingVines) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.WEEPING_VINES) || state.is(Blocks.WEEPING_VINES_PLANT)) && !BoneBoneConfig.floraWeepingVines) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.VINE) && !BoneBoneConfig.floraVine) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.AZALEA) || state.is(Blocks.FLOWERING_AZALEA)) && !BoneBoneConfig.floraAzalea) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.MOSS_BLOCK) && !BoneBoneConfig.floraMoss) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.PALE_MOSS_BLOCK) || state.is(Blocks.PALE_HANGING_MOSS)) && !BoneBoneConfig.floraPaleMoss) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.MOSS_CARPET) && !BoneBoneConfig.floraMossCarpet) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.PALE_MOSS_CARPET) && !BoneBoneConfig.floraPaleMossCarpet) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.ROOTED_DIRT) && !BoneBoneConfig.floraRootedDirt) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.CRIMSON_NYLIUM) && !BoneBoneConfig.floraCrimsonNylium) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.WARPED_NYLIUM) && !BoneBoneConfig.floraWarpedNylium) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.BIG_DRIPLEAF) || state.is(Blocks.BIG_DRIPLEAF_STEM) || state.is(Blocks.SMALL_DRIPLEAF)) && !BoneBoneConfig.floraDripleaf) { cir.setReturnValue(false); return; }
        if ((state.is(Blocks.KELP) || state.is(Blocks.KELP_PLANT)) && !BoneBoneConfig.floraKelp) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.SEAGRASS) && !BoneBoneConfig.floraSeagrass) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.SEA_PICKLE) && !BoneBoneConfig.floraSeaPickle) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.GLOW_LICHEN) && !BoneBoneConfig.floraGlowLichen) { cir.setReturnValue(false); return; }

        // 4. Çiçekler & Otlar (Doğrudan kemik tozu basıldığında çoğaltma/büyüme)
        if (state.is(Blocks.SUNFLOWER) && !BoneBoneConfig.flowerSunflower) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.LILAC) && !BoneBoneConfig.flowerLilac) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.ROSE_BUSH) && !BoneBoneConfig.flowerRoseBush) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.PEONY) && !BoneBoneConfig.flowerPeony) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.PITCHER_PLANT) && !BoneBoneConfig.flowerPitcherPlant) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.PINK_PETALS) && !BoneBoneConfig.flowerPinkPetals) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.OPEN_EYEBLOSSOM) && !BoneBoneConfig.flowerOpenEyeblossom) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.CLOSED_EYEBLOSSOM) && !BoneBoneConfig.flowerClosedEyeblossom) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.SHORT_DRY_GRASS) && !BoneBoneConfig.grassTallDry) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.WILDFLOWERS) && !BoneBoneConfig.flowerWildflowers) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.LEAF_LITTER) && !BoneBoneConfig.flowerLeafLitter) { cir.setReturnValue(false); return; }
        if (state.is(Blocks.CACTUS_FLOWER) && !BoneBoneConfig.flowerCactusFlower) { cir.setReturnValue(false); return; }

        // 5. Çimen Blok (Hepsi kapalıysa etkisiz hale getir)
        if (block instanceof GrassBlock) {
            if (!BoneBoneConfig.grassShort && !BoneBoneConfig.grassTall && !BoneBoneConfig.grassFern && !BoneBoneConfig.grassLargeFern && !BoneBoneConfig.grassShortDry && !BoneBoneConfig.grassTallDry && BoneBoneConfig.areAllFlowersDisabled()) {
                cir.setReturnValue(false);
                return;
            }
        }
    }

    @Inject(method = "useOn", at = @At("RETURN"), cancellable = true)
    private void onUseOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        if (cir.getReturnValue() != InteractionResult.PASS) {
            return;
        }

        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = context.getItemInHand();
        Player player = context.getPlayer();

        // 1. Ekstra: Kaktüs
        if (BoneBoneConfig.extraCactus && state.is(Blocks.CACTUS)) {
            BlockPos topPos = pos;
            while (level.getBlockState(topPos.above()).is(Blocks.CACTUS)) {
                topPos = topPos.above();
            }
            BlockPos bottomPos = pos;
            while (level.getBlockState(bottomPos.below()).is(Blocks.CACTUS)) {
                bottomPos = bottomPos.below();
            }
            int totalHeight = topPos.getY() - bottomPos.getY() + 1;
            BlockPos targetPos = topPos.above();

            if (totalHeight < 3 && level.getBlockState(targetPos).isAir() && Blocks.CACTUS.defaultBlockState().canSurvive(level, targetPos)) {
                if (!level.isClientSide()) {
                    level.setBlockAndUpdate(targetPos, Blocks.CACTUS.defaultBlockState());
                    if (player == null || !player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                    level.levelEvent(1505, targetPos, 15);
                }
                cir.setReturnValue(level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.SUCCESS_SERVER);
                return;
            }
        }

        // 2. Ekstra: Şeker Kamışı
        if (BoneBoneConfig.extraSugarCane && state.is(Blocks.SUGAR_CANE)) {
            BlockPos topPos = pos;
            while (level.getBlockState(topPos.above()).is(Blocks.SUGAR_CANE)) {
                topPos = topPos.above();
            }
            BlockPos bottomPos = pos;
            while (level.getBlockState(bottomPos.below()).is(Blocks.SUGAR_CANE)) {
                bottomPos = bottomPos.below();
            }
            int totalHeight = topPos.getY() - bottomPos.getY() + 1;
            BlockPos targetPos = topPos.above();

            if (totalHeight < 3 && level.getBlockState(targetPos).isAir() && Blocks.SUGAR_CANE.defaultBlockState().canSurvive(level, targetPos)) {
                if (!level.isClientSide()) {
                    level.setBlockAndUpdate(targetPos, Blocks.SUGAR_CANE.defaultBlockState());
                    if (player == null || !player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                    level.levelEvent(1505, targetPos, 15);
                }
                cir.setReturnValue(level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.SUCCESS_SERVER);
                return;
            }
        }

        // 3. Ekstra: Nether Yumrusu
        if (BoneBoneConfig.extraNetherWart && state.is(Blocks.NETHER_WART)) {
            int age = state.getValue(NetherWartBlock.AGE);
            if (age < NetherWartBlock.MAX_AGE) {
                if (!level.isClientSide()) {
                    level.setBlockAndUpdate(pos, state.setValue(NetherWartBlock.AGE, age + 1));
                    if (player == null || !player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                    level.levelEvent(1505, pos, 15);
                }
                cir.setReturnValue(level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.SUCCESS_SERVER);
                return;
            }
        }
    }
}
