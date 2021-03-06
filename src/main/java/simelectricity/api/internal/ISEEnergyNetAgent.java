package simelectricity.api.internal;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import simelectricity.api.components.ISEComponentParameter;
import simelectricity.api.node.ISEGridNode;
import simelectricity.api.node.ISESimulatable;
import simelectricity.api.node.ISESubComponent;

/**
 * Provides access to the SimElectricity EnergyNet
 * <p/>
 * DO NOT use this, internal only!
 * @author rikka0_0
 */
public interface ISEEnergyNetAgent {
    /**
     * @return the node voltage, in volts, refer to ground
     */
    double getVoltage(ISESimulatable node);

    double getCurrentMagnitude(ISESimulatable node);

    boolean canConnectTo(TileEntity tileEntity, EnumFacing direction);

    ISESubComponent newComponent(ISEComponentParameter dataProvider, TileEntity parent);

    ISESimulatable newCable(TileEntity dataProviderTileEntity, boolean isGridInterConnectionPoint);

    ISEGridNode newGridNode(BlockPos pos, int numOfParallelConductor);

    ISEGridNode getGridNodeAt(World world, BlockPos pos);

    boolean isNodeValid(World world, ISESimulatable node);




    /**
     * Add a TileEntity to the energyNet
     */
    void attachTile(TileEntity te);

    void updateTileParameter(TileEntity te);

    void detachTile(TileEntity te);

    void updateTileConnection(TileEntity te);

    void attachGridNode(World world, ISEGridNode node);

    void detachGridNode(World world, ISEGridNode node);

    void connectGridNode(World world, ISEGridNode node1, ISEGridNode node2, double resistance);

    void breakGridConnection(World world, ISEGridNode node1, ISEGridNode node2);

    void makeTransformer(World world, ISEGridNode primary, ISEGridNode secondary, double resistance, double ratio);

    void breakTransformer(World world, ISEGridNode node);
}
