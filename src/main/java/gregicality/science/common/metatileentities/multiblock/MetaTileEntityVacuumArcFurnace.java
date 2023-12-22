package gregicality.science.common.metatileentities.multiblock;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.client.render.GCYSTextures;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockGCYSMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class MetaTileEntityVacuumArcFurnace extends RecipeMapMultiblockController{

    public MetaTileEntityVacuumArcFurnace(ResourceLocation metaTileEntityId){
        super(metaTileEntityId, GCYSRecipeMaps.VACUUM_ARC_FURNACE_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity){
        return new MetaTileEntityVacuumArcFurnace(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("#F#F#", "#F#F#", "#F#F#", "#CCC#", "#CGC#", "#CCC#", "#CCC#", "#CCC#", "#CCC#", "#####")
                .aisle("F###F", "F###F", "F###F", "CIIIC", "CE#EC", "CE#EC", "CE#EC", "CE#EC", "CE#EC", "#COC#")
                .aisle("#####", "#####", "#####", "CIIIC", "G###G", "C###C", "C###C", "C###C", "C###C", "#OMO#")
                .aisle("F###F", "F###F", "F###F", "CIIIC", "CE#EC", "CE#EC", "CE#EC", "CE#EC", "CE#EC", "#COC#")
                .aisle("#F#F#", "#F#F#", "#F#F#", "#CHC#", "#C@C#", "#CJC#", "#CCC#", "#CCC#", "#CCC#", "#####")
                .where('#', any())
                .where('F', getFramePredicate())
                .where('C', states(getCasingState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('H', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('J', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('I', states(getCasingState()).setMinGlobalLimited(5).or(abilities(MultiblockAbility.IMPORT_ITEMS)).or(abilities(MultiblockAbility.IMPORT_FLUIDS)))
                .where('O', states(getCasingState()).setMinGlobalLimited(6).or(abilities(MultiblockAbility.EXPORT_FLUIDS)))
                .where('G', states(getCasingState()).setMinGlobalLimited(2).or(abilities(MultiblockAbility.EXPORT_ITEMS)))
                //TODO change coils to electrodes
                .where('E', heatingCoils())
                .where('@', selfPredicate())
                .build();
    }

    public IBlockState getCasingState() {
        return GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockGCYSMultiblockCasing.CasingType.VACUUM_THERMAL_PROOF_CASING);
    }

    public IBlockState getElectrodeState() {
        return GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockGCYSMultiblockCasing.CasingType.GRAPHITE_ELECTRODE);
    }

    public TraceabilityPredicate getFramePredicate() {return frames(Materials.BlueSteel);}

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {return GCYSTextures.VACCUM_THERMO_PROFF_CASING;}


    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {return Textures.PYROLYSE_OVEN_OVERLAY;}
}
