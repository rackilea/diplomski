import com.sun.jna.Structure;

public class EventsStructure extends Structure
{
    public ServerErrorEvent onServerErrorEvent;

    @SuppressWarnings("rawtypes")
    @Override
    protected List<String> getFieldOrder() 
    {
        List<String> fields = new ArrayList<String>();
        for (Field f : this.getClass().getDeclaredFields())
        {
            boolean has = false;
            for (Class<?> c : f.getType().getInterfaces())
            {
                if (c.equals(DefaultEvent.class))
                {
                    has = true;
                }
            }
            if (has)
            {
                fields.add(f.getName());
            }
        }
        return fields;
    }
}