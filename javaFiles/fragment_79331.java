public class CustomDateTimeFormatInfoImpl_en extends DateTimeFormatInfoImpl_en {

    @Override
    public int firstDayOfTheWeek() {
        // make Sunday my first day of the week
        return 0;
    }
}