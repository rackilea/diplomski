public class DateFormatTransformer implements Transform<Date>
{
    private DateFormat dateFormat;


    public DateFormatTransformer(DateFormat dateFormat)
    {
        this.dateFormat = dateFormat;
    }



    @Override
    public Date read(String value) throws Exception
    {
        return dateFormat.parse(value);
    }


    @Override
    public String write(Date value) throws Exception
    {
        return dateFormat.format(value);
    }

}