public class DateFormatTest {

  private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
    @Override
    protected DateFormat initialValue() {
        return new SimpleDateFormat("yyyyMMdd");
    }
  };

  public Date convert(String source) throws ParseException{
    Date d = df.get().parse(source);
    return d;
  }
}