import java.time.*; import java.time.format.*; import java.util.*;

public class Test {
    public static void main(String[] args) {
        String myFormatNarrow = "dd MMMMM uuuu";
        String myFormatFull = "dd MMMM uuuu";
        String dateToFormat = "26 Juni 2010";
        String dateToFormat2 = "26 J 2010";
        String dateToFormat3 = "26 Jun 2010";
        DateTimeFormatter myFormatter;
        LocalDate myDate;
        myFormatter = new DateTimeFormatterBuilder().appendPattern(myFormatFull)
                    .toFormatter().withResolverStyle(ResolverStyle.STRICT).withLocale(Locale.GERMAN);
        System.out.println("FULL: " + myFormatter.format(LocalDate.of(2010, 6, 26)));
        myDate = LocalDate.parse(dateToFormat, myFormatter);
        System.out.println("PARSED: " + myDate);
        myFormatter = new DateTimeFormatterBuilder().appendPattern(myFormatNarrow)
                    .toFormatter().withResolverStyle(ResolverStyle.STRICT).withLocale(Locale.GERMAN);
        System.out.println("NARROW: " + myFormatter.format(LocalDate.of(2010, 6, 26)));
        myDate = LocalDate.parse(dateToFormat2, myFormatter);
        // It parses a single J as 'july'. Clearly showing why narrow-form is useless here.
        System.out.println("PARSED: " + myDate);
        // note that even ResolverStyle.LENIENT can't do it either; this will fail:
        myFormatter = myFormatter.withResolverStyle(ResolverStyle.LENIENT);
    //   myDate = LocalDate.parse(dateToFormat3, myFormatter);
    // System.out.println("PARSED: " + myDate);
    }
}