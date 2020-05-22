@SuppressWarnings("serial")
public static class XmlModule extends SimpleModule
{
    public XmlModule()
    {
        super("XmlModule");
    }

    @Override
    public void setupModule(SetupContext context)
    {
        context.setMixInAnnotations(Data.class, XmlData.class);
    }
}