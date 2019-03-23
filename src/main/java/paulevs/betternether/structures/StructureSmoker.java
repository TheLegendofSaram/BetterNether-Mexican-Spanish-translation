package paulevs.betternether.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherrack;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import paulevs.betternether.blocks.BlocksRegister;

public class StructureSmoker implements IStructure
{
	@Override
	public void generate(Chunk chunk, BlockPos pos, Random random)
	{
		if (pos.getX() > 3 && pos.getZ() > 3 && pos.getX() < 13 && pos.getZ() < 13)
		{
			Block under = chunk.getBlockState(pos).getBlock();
			if (under instanceof BlockNetherrack || under == Blocks.SOUL_SAND)
			{
				IBlockState state = BlocksRegister.BLOCK_SMOKER.getDefaultState();
				for (int i = 0; i < 8; i++)
				{
					int x = pos.getX() + (int) (random.nextGaussian() * 2);
					int z = pos.getZ() + (int) (random.nextGaussian() * 2);
					int y = pos.getY() + random.nextInt(6);
					for (int j = 0; j < 6; j++)
					{
						BlockPos npos = new BlockPos(x, y - j, z);
						if (npos.getY() > 31)
						{
							under = chunk.getBlockState(npos.down()).getBlock();
							if (under instanceof BlockNetherrack || under == Blocks.SOUL_SAND)
							{
								int h = 1 + random.nextInt(5);
								for (int k = 0; k < h; k++)
								{
									BlockPos cp = npos.up(k);
									if (chunk.getBlockState(cp).getBlock() == Blocks.AIR)
										chunk.setBlockState(cp, state);
									else
										break;
								}
								break;
							}
						}
						else
							break;
					}
				}
			}
		}
	}
}
