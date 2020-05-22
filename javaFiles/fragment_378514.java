import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public static Date toDateJoda(int intDate) {
    LocalDate ldt = new LocalDate(
        intDate / 10000,
        (intDate / 100) % 100,
        intDate % 100);

    DateTime dt = ldt.toDateTimeAtStartOfDay();
    return dt.toDate();
}