import java.time.*;
import java.time.chrono.*;
import java.time.temporal.*;

public class Test {
    public static void main(String[] args) {
        Chronology hijrah = HijrahChronology.INSTANCE;
        ValueRange range = hijrah.range(ChronoField.YEAR);
        System.out.println(range.getMinimum());
        System.out.println(range.getMaximum());
    }
}