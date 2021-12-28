package me.jakez.bettersense.mixin;

import org.spongepowered.asm.mixin.Mixin;

import me.jakez.bettersense.DamageSourceCustom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(StonecutterBlock.class)
public class StonecutterBlockMixin extends Block {

    public StonecutterBlockMixin(Settings settings) {
		super(settings);
	}

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);

        /* TODO: Make configurable */
        boolean dealDamage = true;
        boolean deleteItem = true;

        if (!(dealDamage && deleteItem)) return;

        if (dealDamage) {
            if (deleteItem && !entity.isLiving()) {
                world.addParticle(
                    ParticleTypes.LAVA, 
                    entity.getPos().getX(),
                    entity.getPos().getY(),
                    entity.getPos().getZ(), 
                    0.0, 0.0, 0.0
                );
            } else if (!(deleteItem && entity.isLiving())) return;

            entity.damage(DamageSourceCustom.STONECUTTER, 1.5f);
        }
    }
}