package com.ykisl.extendedmechanics.blocks.builder;

import com.ykisl.extendedmechanics.blocks.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSourceImpl;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class BuilderBlock extends BaseEntityBlock
{
	private static final float strength = 9f;

	public BuilderBlock() 
	{
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(strength));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) 
	{
		return new BuilderBlockEntity(blockPos, blockState);
	}
	
	@Override
	public RenderShape getRenderShape(BlockState blockState) 
	{
		return RenderShape.MODEL;
	}
	
	@Override
	public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) 
	{
		if(!level.isClientSide) 
		{
			var entity = level.getBlockEntity(blockPos);
			if(entity instanceof BuilderBlockEntity builderEntity) 
			{
				NetworkHooks.openGui((ServerPlayer) player, builderEntity, blockPos);
			}
		}
		
		return InteractionResult.sidedSuccess(level.isClientSide);
	}
	
	/*@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) 
	{
		return createTickerHelper(blockEntityType, ModBlocks.BUILDER_BLOCK.get(), BuilderBlockEntity::tick)
	}*/
	
	
}
