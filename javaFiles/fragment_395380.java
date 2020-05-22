@Root(name = "Example")
public class Example
{
    @Element
    @Convert(ExampleConverter.class)
    private HashMap<String, String> attributes; // Will use the Converter instead

    // ...

    public static class ExampleConverter implements Converter<HashMap<String, String>>
    {
        @Override
        public HashMap<String, String> read(InputNode node) throws Exception
        {
            // Implement if needed
        }


        @Override
        public void write(OutputNode node, HashMap<String, String> value) throws Exception
        {
            value.forEach((k, v) -> {
                try
                {
                    node.getChild("name").setValue(k);
                    node.getChild("value").setValue(v);
                }
                catch( Exception ex )
                {
                    // Handle Error
                }
            });
        }

    }
}