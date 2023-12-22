package gregicality.science.loaders.recipe.chain;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.api.unification.materials.GCYSMaterials;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;

public class PTFEChain {
    public static void init() {
        difluorinemethane();
        antimonypentafluoride();
        tetrafluorethylene();
    }

    public static void difluorinemethane(){
        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(GCYSMaterials.AntimonyPentafluoride.getFluid(1000))
                .fluidInputs(Materials.Chloroform.getFluid(1000))
                .fluidInputs(Materials.HydrofluoricAcid.getFluid(2000))
                .fluidOutputs(GCYSMaterials.Difluorochloromethane.getFluid(1000))
                .fluidOutputs(Materials.HydrochloricAcid.getFluid(2000))
                .duration(800).EUt(VA[HV]).buildAndRegister();
    }

    public static void antimonypentafluoride() {
        RecipeMaps.LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(OrePrefix.dust, Materials.AntimonyTrifluoride, 4)
                .fluidInputs(Materials.Fluorine.getFluid(8000))
                .fluidOutputs(GCYSMaterials.AntimonyPentafluoride.getFluid(16000))
                .duration(300).EUt(VA[MV]).buildAndRegister();

        RecipeMaps.CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(new IntCircuitIngredient(1))
                .input(OrePrefix.dust, Materials.AntimonyTrioxide, 1)
                .fluidInputs(Materials.HydrofluoricAcid.getFluid(10000))
                .fluidOutputs(Materials.Water.getFluid(5000))
                .fluidOutputs(GCYSMaterials.AntimonyPentafluoride.getFluid(2000))
                .duration(800).EUt(VA[HV]).buildAndRegister();

    }

    public static void tetrafluorethylene() {

        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CHEMICAL_RECIPES,
                new FluidStack[]{Materials.HydrofluoricAcid.getFluid(4000), Materials.Chloroform.getFluid(2000)});

        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.LARGE_CHEMICAL_RECIPES,
                new ItemStack[]{IntCircuitIngredient.getIntegratedCircuit(24)},
                new FluidStack[]{Materials.Chlorine.getFluid(12000), Materials.Methane.getFluid(2000), Materials.HydrofluoricAcid.getFluid(4000)});

        GCYSRecipeMaps.PYROLISEREACTOR_RECIPE.recipeBuilder()
                .fluidInputs(GCYSMaterials.Difluorochloromethane.getFluid(2000))
                .fluidOutputs(Materials.Tetrafluoroethylene.getFluid(1000))
                .fluidOutputs(Materials.HydrochloricAcid.getFluid(2000))
                .duration(600).EUt(VA[HV]).buildAndRegister();
    }
}
