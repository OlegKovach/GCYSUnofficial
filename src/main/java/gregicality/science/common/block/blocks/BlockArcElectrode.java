package gregicality.science.common.block.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class BlockArcElectrode extends VariantBlock<BlockArcElectrode.ArcElectrodeType> {
    public BlockArcElectrode() {
        super(Material.IRON);
        setTranslationKey("arc_electrode");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 1);
        setDefaultState(getState(ArcElectrodeType.GRAPHITE_ELECTRODE));
    }

    public enum ArcElectrodeType implements IStringSerializable {
        GRAPHITE_ELECTRODE("graphite"),

        GRAPHENE_ELECTRODE("graphene");

        private final String name;

        @Nonnull
        @Override
        public String getName() {
            return name;
        }

        ArcElectrodeType(String name){
            this.name = name;
        }
    }
}
