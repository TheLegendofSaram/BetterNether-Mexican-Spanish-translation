package org.betterx.betternether.blocks;

import org.betterx.bclib.blocks.BaseStripableBarkBlock;
import org.betterx.bclib.blocks.BlockProperties.TripleShape;
import org.betterx.bclib.interfaces.tools.AddMineableAxe;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.MapColor;

public class RubeusBark extends BaseStripableBarkBlock.Wood implements AddMineableAxe {
    public RubeusBark(MapColor color, Block striped) {
        super(color, striped, false);
        this.registerDefaultState(this.defaultBlockState()
                                      .setValue(AXIS, Direction.Axis.Y)
                                      .setValue(RubeusLog.SHAPE, TripleShape.BOTTOM));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        super.createBlockStateDefinition(stateManager);
        stateManager.add(RubeusLog.SHAPE);
    }
}
