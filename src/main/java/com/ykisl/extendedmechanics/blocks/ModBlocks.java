package com.ykisl.extendedmechanics.blocks;

import java.util.function.Supplier;

import com.ykisl.extendedmechanics.ExtendedMechanics;
import com.ykisl.extendedmechanics.blocks.builder.BuilderBlock;
import com.ykisl.extendedmechanics.items.ModItems;

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

public class ModBlocks 
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExtendedMechanics.MODID);
	
	public static final RegistryObject<Block> BUILDER_BLOCK = BLOCKS.register("builder", () -> new BuilderBlock());
	
	public static void Register(IEventBus eventBus) 
	{
		BLOCKS.register(eventBus);
	}
	
	public static void ClientSetup(FMLClientSetupEvent event, IEventBus eventBus) 
	{
		
	}
}
