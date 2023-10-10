package gregicality.science.client.render;

import gregicality.science.GregicalityScience;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;


@Mod.EventBusSubscriber(modid = GregicalityScience.MODID, value = Side.CLIENT)
public class GCYSTextures {

    public static OrientedOverlayRenderer DRYER_OVERLAY = new OrientedOverlayRenderer("machines/dryer");
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblock/crystallization_crucible");
    public static OrientedOverlayRenderer ROASTER_OVERLAY = new OrientedOverlayRenderer("multiblock/roaster");
    public static OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/nanoscale_fabricator");
    public static OrientedOverlayRenderer CVD_UNIT_OVERLAY = new OrientedOverlayRenderer("multiblock/cvd_unit");
    public static OrientedOverlayRenderer BURNER_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/burner_reactor");
    public static OrientedOverlayRenderer CRYOGENIC_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/cryogenic_reactor");
    public static OrientedOverlayRenderer FRACKER_OVERLAY = new OrientedOverlayRenderer("multiblock/fracker");
    public static OrientedOverlayRenderer SONICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/sonicator");
    public static OrientedOverlayRenderer CATALYTIC_REFORMER_OVERLAY = new OrientedOverlayRenderer("multiblock/catalytic_reformer");
    public static OrientedOverlayRenderer INDUSTRIAL_DRILL_OVERLAY = new OrientedOverlayRenderer("multiblock/industrial_drill");
    public static OrientedOverlayRenderer SUBSONIC_AXIAL_COMPRESSOR_OVERLAY = new OrientedOverlayRenderer("multiblock/subsonic_axial_compressor");
    public static OrientedOverlayRenderer SUPERSONIC_AXIAL_COMPRESSOR_OVERLAY = new OrientedOverlayRenderer("multiblock/supersonic_axial_compressor");
    public static OrientedOverlayRenderer LOW_POWER_TURBOMOLECULAR_PUMP = new OrientedOverlayRenderer("multiblock/low_power_turbomolecular_pump");
    public static OrientedOverlayRenderer HIGH_POWER_TURBOMOLECULAR_PUMP = new OrientedOverlayRenderer("multiblock/high_power_turbomolecular_pump");

    public static OrientedOverlayRenderer CZ_PULLER = new OrientedOverlayRenderer("multiblock/cz_puller");

    //public static OrientedOverlayRenderer MASS_NULLIFIER_PLATFORM = new OrientedOverlayRenderer("casings/mass_nullifier_platform");

    public static TextureAtlasSprite PRESSURE_PIPE_SIDE;
    public static TextureAtlasSprite PRESSURE_PIPE_OPEN;

    @SideOnly(Side.CLIENT)
    public static void register(TextureMap textureMap) {
        PRESSURE_PIPE_SIDE = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/pressure_pipe_side"));
        PRESSURE_PIPE_OPEN = textureMap.registerSprite(new ResourceLocation(GregicalityScience.MODID, "blocks/pipe/pressure_pipe_open"));
    }

}
