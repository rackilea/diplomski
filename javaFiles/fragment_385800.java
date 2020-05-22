public class TimeUnitConverter implements Converter<TimeUnit>
{
    @Override
    public TimeUnit read(InputNode node) throws Exception
    {
        return TimeUnit.valueOf(node.getValue().toUpperCase());
    }


    @Override
    public void write(OutputNode node, TimeUnit value) throws Exception
    {
        node.getAttributes().remove("class"); /* Not required */
        node.setValue(value.toString().toLowerCase());
    }

}