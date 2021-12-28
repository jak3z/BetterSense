package me.jakez.bettersense.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(CactusBlock.class)
public class CactusBlockMixin extends Block {

	public CactusBlockMixin(Settings settings) {
		super(settings);
	}
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        /* TODO: Make configurable */
        boolean deleteItem = false;

        if (!(deleteItem && entity.isLiving())) return;

        entity.damage(DamageSource.CACTUS, 1.0f);

        super.onEntityCollision(state, world, pos, entity);
    }
}
