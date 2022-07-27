package com.ykisl.extendedmechanics.blocks.builder;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.DispenserMenu;

public class BuilderBlockMenu extends DispenserMenu
{
	public BuilderBlockMenu(int containerId, Inventory inventory) 
	{
		super(containerId, inventory);
	}

}
