package com.ykisl.extendedmechanics.events;

import com.ykisl.extendedmechanics.ExtendedMechanics;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ExtendedMechanics.MODID)
public class EventBusEvents 
{
	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinWorldEvent entityJoinWorldEvent) 
	{
	} 
}
