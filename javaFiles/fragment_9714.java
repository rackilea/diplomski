[system:/tmp]$ cat Loc.java
import org.joda.time.*;
import java.util.Locale;

class Loc {
    public static void main(String[] args) {
        Locale locale = new Locale("nb","no");
        MutableDateTime start = new MutableDateTime(2012,1, 10,10,0,0,0 );
        start.setDayOfWeek(DateTimeConstants.SATURDAY);
        System.out.println(start.dayOfWeek().getAsText(locale));
        System.out.println(locale.getISO3Language().toString());
    }
}
[system:/tmp]$ java Loc
lørdag
nob