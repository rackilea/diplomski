import java.time.LocalDate;

public class DNumberLocalDate {

    private final LocalDate localDate;
    private final boolean isDNumber;

    public DNumberLocalDate(LocalDate localDate, boolean isDNumber) {
        this.localDate = localDate;
        this.isDNumber = isDNumber;
    }

    public DNumberLocalDate(LocalDate localDate) {
        this(localDate, false);
    }

    public int getDayOfMonth() {
        return isDNumber ? localDate.getDayOfMonth() + 40 : localDate.getDayOfMonth();
    }

}