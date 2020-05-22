public class GenericNodeConverter implements Converter<GenericNode>
{
    @Override
    public GenericNode read(InputNode node) throws Exception
    {
        GenericNode gn = new GenericNode();

        gn.setId(Integer.valueOf(node.getAttribute("id").getValue()));
        gn.setType(node.getAttribute("type").getValue());
        gn.setName(node.getName());

        return gn;
    }


    @Override
    public void write(OutputNode node, GenericNode value) throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}