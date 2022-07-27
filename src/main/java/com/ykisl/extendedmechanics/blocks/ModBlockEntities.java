package com.ykisl.extendedmechanics.blocks;

import java.util.function.Supplier;

import org.apache.commons.lang3.ObjectUtils.Null;

import com.ykisl.extendedmechanics.ExtendedMechanics;
import com.ykisl.extendedmechanics.blocks.builder.BuilderBlockEntity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities 
{
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
			DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ExtendedMechanics.MODID);
	
	public static final RegistryObject<BlockEntityType<BuilderBlockEntity>> BUILDER_BLOCK_ENTITY = 
			BLOCK_ENTITIES.register("builder_block_entity", () -> 
			{
				return Builder.of(BuilderBlockEntity::new, ModBlocks.BUILDER_BLOCK.get()).build(null);
			});	
	
	public static void Register(IEventBus eventBus) 
	{
		BLOCK_ENTITIES.register(eventBus);
	}
	
	public static void ClientSetup(FMLClientSetupEvent event, IEventBus eventBus) 
	{
		
	}
}
