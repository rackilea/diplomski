import org.threeten.bp.Instant;
import org.threeten.bp.temporal.ChronoUnit;

public static boolean hasDateExpired(int days, Instant savedDate, Instant currentDate) {
    boolean hasExpired = false;

    if (savedDate != null && currentDate != null) {
        // nanoseconds between savedDate and currentDate > number of nanoseconds in the specified number of days
        if (ChronoUnit.NANOS.between(savedDate, currentDate) > days * ChronoUnit.DAYS.getDuration().toNanos()) {
            hasExpired = true;
        }
    }

    return hasExpired;
}