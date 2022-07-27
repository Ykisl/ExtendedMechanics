package com.ykisl.extendedmechanics.events;

import javax.annotation.Nonnull;

import com.ykisl.extendedmechanics.ExtendedMechanics;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ExtendedMechanics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents 
{
	@SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
    {
    }
}
