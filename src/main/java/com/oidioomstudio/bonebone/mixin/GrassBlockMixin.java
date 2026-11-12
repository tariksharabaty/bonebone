package com.oidioomstudio.bonebone.mixin;

import com.oidioomstudio.bonebone.config.BoneBoneConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealSource;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GrassBlock.class)
public class GrassBlockMixin {

    @Inject(
        method = "placeBonemealEffect",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/BonemealableBlock;performBonemeal(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/BonemealSource;)V"
        ),
        cancellable = true
    )
    private static void onGrowTallGrass(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BonemealSource bonemealSource, CallbackInfo ci) {
        BlockState currentState = serverLevel.getBlockState(blockPos);
        if (currentState.is(Blocks.SHORT_GRASS) && !BoneBoneConfig.grassTall) {
            ci.cancel();
        } else if (currentState.is(Blocks.FERN) && !BoneBoneConfig.grassLargeFern) {
            ci.cancel();
        } else if (currentState.is(Blocks.SHORT_DRY_GRASS) && !BoneBoneConfig.grassTallDry) {
            ci.cancel();
        }
    }

    @Inject(
        method = "placeBonemealEffect",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/levelgen/feature/Feature;place(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;)Z"
        ),
        cancellable = true
    )
    private static void onPlaceFlowerFeature(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BonemealSource bonemealSource, CallbackInfo ci) {
        if (BoneBoneConfig.areAllFlowersDisabled()) {
            ci.cancel();
        }
    }

    @Inject(
        method = "placeBonemealEffect",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/levelgen/feature/Feature;place(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;)Z",
            shift = At.Shift.AFTER
        )
    )
    private static void onAfterPlaceFlowerFeature(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BonemealSource bonemealSource, CallbackInfo ci) {
        BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos abovePos = new BlockPos.MutableBlockPos();
        int originX = blockPos.getX();
        int originY = blockPos.getY();
        int originZ = blockPos.getZ();

        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                for (int dy = -1; dy <= 1; dy++) {
                    checkPos.set(originX + dx, originY + dy, originZ + dz);
                    BlockState state = serverLevel.getBlockState(checkPos);
                    Block block = state.getBlock();
                    if (BoneBoneConfig.isFlowerBlock(block) && !BoneBoneConfig.isFlowerAllowed(block)) {
                        serverLevel.setBlock(checkPos, Blocks.AIR.defaultBlockState(), 3);
                        abovePos.set(originX + dx, originY + dy + 1, originZ + dz);
                        BlockState aboveState = serverLevel.getBlockState(abovePos);
                        if (aboveState.is(block)) {
                            serverLevel.setBlock(abovePos, Blocks.AIR.defaultBlockState(), 3);
                        }
                    }
                }
            }
        }
    }

    @Inject(
        method = "placeBonemealEffect",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/levelgen/placement/PlacedFeature;place(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;)Z"
        ),
        cancellable = true
    )
    private static void onPlaceGrassFeature(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BonemealSource bonemealSource, CallbackInfo ci) {
        if (!BoneBoneConfig.grassShort && !BoneBoneConfig.grassFern && !BoneBoneConfig.grassShortDry) {
            ci.cancel();
        }
    }

    @Inject(
        method = "placeBonemealEffect",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/levelgen/placement/PlacedFeature;place(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;)Z",
            shift = At.Shift.AFTER
        )
    )
    private static void onAfterPlaceGrassFeature(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BonemealSource bonemealSource, CallbackInfo ci) {
        BlockState placedState = serverLevel.getBlockState(blockPos);
        if (placedState.is(Blocks.SHORT_GRASS) && !BoneBoneConfig.grassShort) {
            serverLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
        } else if (placedState.is(Blocks.FERN) && !BoneBoneConfig.grassFern) {
            serverLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
        } else if (placedState.is(Blocks.SHORT_DRY_GRASS) && !BoneBoneConfig.grassShortDry) {
            serverLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
        }
    }
}
