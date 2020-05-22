public static String[] SUBNAMES;
private IIcon[] icon;

public ExampleMetaBlock(Material material, String name, CreativeTabs tab, String[] subnames)
{
    super(material, name, tab);
    SUBNAMES = subnames;
}