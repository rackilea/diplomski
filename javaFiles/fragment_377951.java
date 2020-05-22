import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

for (TextStyle ts : TextStyle.values()) {
    System.out.print(ts + ":  ");
    System.out.print(Month.OCTOBER.getDisplayName(ts, Locale.ENGLISH ) + " / ");  // English
    System.out.print(Month.OCTOBER.getDisplayName(ts, Locale.forLanguageTag("cs")) + " / ");  // Czech
    System.out.print(Month.OCTOBER.getDisplayName(ts, Locale.forLanguageTag("ru")) + " / ");  // Russian
    System.out.println(Month.OCTOBER.getDisplayName(ts, Locale.forLanguageTag("pl")));  // Polish
}