package com.ykisl.extendedmechanics;

import com.mojang.logging.LogUtils;
import com.ykisl.extendedmechanics.blocks.ModBlockEntities;
import com.ykisl.extendedmechanics.blocks.ModBlocks;
import com.ykisl.extendedmechanics.events.EventBusEvents;
import com.ykisl.extendedmechanics.items.ModItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;

@Mod(ExtendedMechanics.MODID)
public class ExtendedMechanics
{
    public static final String MODID = "extendedmechanics";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExtendedMechanics()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        
        var eventBus = GetEventBus();
        
		ModBlocks.Register(eventBus);
		ModBlockEntities.Register(eventBus);
		ModItems.Register(eventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventBusEvents());
    }
    
	public void setup(final FMLCommonSetupEvent event)
    {
		var eventBus = GetEventBus();
    }
	
    public void onClientSetup(FMLClientSetupEvent event)
    {
    	var eventBus = GetEventBus();
    	
    	ModBlocks.ClientSetup(event, eventBus);
		ModBlockEntities.ClientSetup(event, eventBus);
		ModItems.ClientSetup(event, eventBus);
    }
	
	@SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    	var logger = ExtendedMechanics.GetLogger();
    	logger.info("HELLO from server starting");
    }
	
    public static Logger GetLogger() 
    {
    	return LOGGER;
    }
    
    private IEventBus GetEventBus() 
    {
    	return FMLJavaModLoadingContext.get().getModEventBus();
    }
}
