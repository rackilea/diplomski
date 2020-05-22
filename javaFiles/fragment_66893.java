public class SettingsConverter implements Converter<Settings>
{
    private Transformer transformer;


    public SettingsConverter()
    {
        this.transformer = new Transformer(new RegistryMatcher());
    }



    @Override
    public Settings read(InputNode node) throws Exception
    {
        Settings settings = new Settings();
        InputNode child = node.getNext();

        while( child != null )
        {
            final String key = child.getAttribute("key").getValue();
            final Class c = Class.forName(child.getAttribute("class").getValue());

            settings.put(key, transformer.read(child.getAttribute("value").getValue(), c));
            child = node.getNext();
        }

        return settings;
    }


    @Override
    public void write(OutputNode node, Settings value) throws Exception
    {
        for( Map.Entry<String, Object> entry : value.entrySet() )
        {
            OutputNode child = node.getChild("setting");

            child.setAttribute("key", entry.getKey());
            child.setAttribute("class", entry.getValue().getClass().getName());
            child.setAttribute("value", transformer.write(entry.getValue(), entry.getValue().getClass())); 
        }   
    }
}