package com.ykisl.extendedmechanics.items;

import java.util.HashMap;

import com.ykisl.extendedmechanics.ExtendedMechanics;
import com.ykisl.extendedmechanics.blocks.ModBlocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems 
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExtendedMechanics.MODID);
	
	//BLOCK_ITEMS
	public static final RegistryObject<Item> BUILDER_BLOCK_ITEM = ITEMS.register("builder", () ->
	new BlockItem(ModBlocks.BUILDER_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
	
	public static void Register(IEventBus eventBus) 
	{
		ITEMS.register(eventBus);
	}
	
	public static void ClientSetup(FMLClientSetupEvent event, IEventBus eventBus) 
	{
		
	}
}
