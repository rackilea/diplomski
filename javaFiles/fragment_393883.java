import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

enum PatternShorter { // or PatternMonthDayOnly
    MM_SLASH_DD     ("MM/dd")
    , DD_SLASH_MM   ("dd/MM")
    ;
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    private PatternShorter(String pattern) {
        this.pattern = pattern;
    }

    public static PatternShorter getDefault() { return DD_SLASH_MM; }
}

public class DateFormatEx {
    private static Map<Locale, PatternShorter> patternShorter = new HashMap<>();

    static {
        patternShorter.put(Locale.UK, PatternShorter.DD_SLASH_MM);
        patternShorter.put(Locale.UK, PatternShorter.MM_SLASH_DD);
        // any locale not listed here will get the default pattern
    }

    private static String getPattern (Locale locale) {      
        if (patternShorter.get(locale)!=null) {
            return patternShorter.get(locale).getPattern();
        } else {
            return PatternShorter.getDefault().getPattern();
        }
    }

    public static void main(String[] args) {
        List<Locale> listOfLocale = Arrays.asList(Locale.UK, Locale.US, Locale.FRENCH);
        for (Locale locale : listOfLocale) {
            SimpleDateFormat fmt 
            = new SimpleDateFormat(getPattern(locale), locale);
            System.out.format("for locale %s the shorter date/month display is: %s%n"
                    , locale.toString()
                    , fmt.format(new Date()));  
        }
    }

}