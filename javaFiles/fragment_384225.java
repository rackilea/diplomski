public class GenericBlockOre extends BlockOre
{
    final String name;

    @SideOnly(Side.CLIENT)
    public IIcon iconOre, iconNetherOre, iconEndOre;

    public GenericBlockOre(final int id, final String name)
    {
        super(id);
        this.name = name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        iconOre = iconRegister.registerIcon(Reference.MODID + ":End" + this.name + "Ore");
        iconNetherOre = iconRegister.registerIcon(Reference.MODID + ":Nether" + this.name + "Ore");
        iconEndOre = iconRegister.registerIcon(Reference.MODID + ":" + this.name + "Ore");
    }
}