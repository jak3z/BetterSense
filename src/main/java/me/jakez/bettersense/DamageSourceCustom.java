package me.jakez.bettersense;

import net.minecraft.entity.damage.DamageSource;

public class DamageSourceCustom extends DamageSource {
	public static final DamageSource STONECUTTER = new DamageSourceCustom("stonecutter").setBypassesArmor();

	public DamageSourceCustom(String name) {
		super(name);
	}

	@Override
	public DamageSource setBypassesArmor() {
		return super.setBypassesArmor();
	}
}
