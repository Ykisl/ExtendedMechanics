package com.ykisl.extendedmechanics.blocks.builder;

import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import org.spongepowered.asm.mixin.MixinEnvironment.Side;

import com.ykisl.extendedmechanics.blocks.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DispenserMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BuilderBlockEntity extends BlockEntity implements MenuProvider
{
	public static final int CONTAINER_SIZE = 9;
	private final ItemStackHandler itemHandler = new ItemStackHandler(CONTAINER_SIZE) 
	{
		@Override
		protected void onContentsChanged(int slot) 
		{
			setChanged();
		}
	};
	
	private LazyOptional<ItemStackHandler> lazyItemHandler = LazyOptional.empty();
	
	protected BuilderBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) 
	{
		super(blockEntityType, blockPos, blockState);
	}

	public BuilderBlockEntity(BlockPos blockPos, BlockState blockState) 
	{
		this(ModBlockEntities.BUILDER_BLOCK_ENTITY.get(), blockPos, blockState);
	}
	
	public int getContainerSize() 
	{
		return CONTAINER_SIZE;
	}
	
	@Override
	public Component getDisplayName() 
	{
		return new TranslatableComponent("container.builder");
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int p_59637_, Inventory inventory, Player player) 
	{
		return new BuilderBlockMenu(p_59637_, inventory);
	}
	
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) 
	{
		if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side != Direction.UP) 
		{
			return lazyItemHandler.cast();
		}
		
		return super.getCapability(cap, side);
	}
	
	@Override
	public void onLoad() 
	{
		super.onLoad();
		lazyItemHandler = LazyOptional.of(() -> itemHandler);
	}
	
	@Override
	public void invalidateCaps() 
	{
		super.invalidateCaps();
		lazyItemHandler.invalidate();
	}
	
	@Override
	protected void saveAdditional(CompoundTag compoundTag) 
	{
		compoundTag.put("inventory", itemHandler.serializeNBT());
		super.saveAdditional(compoundTag);
	}
	
	public void DropItems() 
	{
		var container = new SimpleContainer(itemHandler.getSlots());
		for(int i = 0; i < itemHandler.getSlots(); i++) 
		{
			var item = itemHandler.getStackInSlot(i);
			container.setItem(i, item);
		}
		
		Containers.dropContents(this.level, this.worldPosition, container);
	}
}
