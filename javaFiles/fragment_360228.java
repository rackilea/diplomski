public class BriefFormatter extends Formatter 
{   
    public BriefFormatter() { super(); }

    @Override 
    public String format(final LogRecord record) 
    {
        return record.getMessage();
    }   
}