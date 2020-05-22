public class ExampleConverter implements Converter<Example>
{
    @Override
    public Example read(InputNode node) throws Exception
    {
        List<String> list = new ArrayList<>(); // List to insert the 'col_' values

        NodeMap<InputNode> attributes = node.getAttributes(); // All attributes of the node
        Iterator<String> itr = attributes.iterator();

        while( itr.hasNext() ) // Iterate over all attributes
        {
            final String name = itr.next(); // The name of the attribute

            if( name.startsWith("col_") ) // Check if it is a 'col' attribute
            {
                // Insert the value of the 'col_' attribute
                list.add(attributes.get(name).getValue());
            }
        }

        // Return the result - instead of a constructor you can use setter(s) too
        return new Example(list); 
    }


    @Override
    public void write(OutputNode node, Example value) throws Exception
    {
        // TODO: Implement serializing here - only required if you want to serialize too
    }
}