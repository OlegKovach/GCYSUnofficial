package gregicality.science.common.metatileentities.multiblock;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
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
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class MetaTileEntityPyroliseReactor extends RecipeMapMultiblockController{

    public MetaTileEntityPyroliseReactor(ResourceLocation metaTileEntityId){
        super(metaTileEntityId, GCYSRecipeMaps.PYROLISEREACTOR_RECIPE);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity){
        return new MetaTileEntityPyroliseReactor(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("FFFFFFF", "CCCCCCC", "##FFF##", "##FFF##", "##FFF##", "##FFF##", "##CCC##")
                .aisle("F#####F", "CCCCCCC", "#FHHHF#", "#FHHHF#", "#FHHHF#", "#FHHHF#", "#CCCCC#")
                .aisle("F#####F", "CCCCCCC", "CH###HC", "CH###HC", "FH###HF", "FH###HF", "CCOOOCC")
                .aisle("F#####F", "CCCCCCC", "I#####I", "CH###HC", "FH###HF", "FH###HF", "CCOMOCC")
                .aisle("F#####F", "CCCCCCC", "CH###HC", "CH###HC", "FH###HF", "FH###HF", "CCOOOCC")
                .aisle("F#####F", "CCCCCCC", "#FH#HF#", "#FHHHF#", "#FHHHF#", "#FHHHF#", "#CCCCC#")
                .aisle("#F###F#", "#CCECC#", "##C@C##", "##CJC##", "#######", "#######", "#######")
                .where('F', getFramePredicate())
                .where('C', states(getCasingState()))
                .where('H', heatingCoils())
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('O', states(getCasingState()).setMinGlobalLimited(7)
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS)))
                .where('I', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('J', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('@', selfPredicate())
                .where('#', any())
                .build();
    }

    public IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }

    public TraceabilityPredicate getFramePredicate(){
        return frames(Materials.StainlessSteel);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart){
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {return Textures.PYROLYSE_OVEN_OVERLAY;}
}
