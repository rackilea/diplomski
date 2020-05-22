static {
    // this would be initialized like something as follows when the application starts
    // which causes the headaches of SimpleDateFormat not to work...
    SimpleTimeZone tz = new SimpleTimeZone(0, "Out Timezone");             
    TimeZone.setDefault(tz);  
}

// therefore this class will workaround the issue, 

public class OurOwnCustomDateFormat
    extends SimpleDateFormat {

    /** The pattern to use as the format string. */
    protected String pattern;

    public OurOwnCustomDateFormat(String pattern) {
         super(pattern);
         // store the pattern
         this.pattern = pattern;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) {

         // custom implementation to format the date and time based on our TimeZone            
         toAppendTo.insert(pos.getBeginIndex(), "the date with our custom format calculated here");
         return toAppendTo; 
    }