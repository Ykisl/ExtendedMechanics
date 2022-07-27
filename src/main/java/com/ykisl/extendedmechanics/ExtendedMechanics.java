package com.ykisl.extendedmechanics;

import com.mojang.logging.LogUtils;
import com.ykisl.extendedmechanics.events.EventBusEvents;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.jetbrains.annotations.Debug;
import org.slf4j.Logger;

import java.util.stream.Collectors;

@Mod(ExtendedMechanics.MODID)
public class ExtendedMechanics
{
    public static final String MODID = "extendedmechanics";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExtendedMechanics()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventBusEvents());
    }
    
	public void setup(final FMLCommonSetupEvent event)
    {
    	var logger = ExtendedMechanics.GetLogger();
    	
    	logger.info("HELLO FROM PREINIT");
    	logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
	
    public void onClientSetup(FMLClientSetupEvent event)
    {
		LOGGER.debug("CLIENT SETUP");
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
}
