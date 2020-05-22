public class JodaDateTimeExercise {

    private static final String PATTERN = "MMM $$ HH:mm";

    public static void main(String[] args) {
        DateTime dateTimeBegin = new DateTime(2000, 3, 1, 3, 0);
        DateTime dateTimeEnd = dateTimeBegin.plusMinutes(239);

        DateTime dateTimeBeginCopy = dateTimeBegin;
        DateTime dateTimeEndCopy = dateTimeEnd;

        for (int dayIndex = 0; dayIndex < 31; dayIndex++) {
            printDateTime(dateTimeBeginCopy, dateTimeEndCopy);

            dateTimeBeginCopy = dateTimeBeginCopy.plusHours(4);
            dateTimeEndCopy = dateTimeEndCopy.plusHours(8);

            printDateTime(dateTimeBeginCopy, dateTimeEndCopy);

            dateTimeBeginCopy = dateTimeBeginCopy.plusHours(8);
            dateTimeEndCopy = dateTimeEndCopy.plusHours(12);

            printDateTime(dateTimeBeginCopy, dateTimeEndCopy);

            dateTimeBegin = dateTimeBegin.plusDays(1);
            dateTimeEnd = dateTimeEnd.plusDays(1);

            dateTimeBeginCopy = dateTimeBegin;
            dateTimeEndCopy = dateTimeEnd;
        }
    }

    private static void printDateTime(DateTime dateTimeBegin, DateTime dateTimeEnd) {
        System.out.print(dateTimeBegin.toString(PATTERN, Locale.US).replace("$$", formatDayOfMonth(dateTimeBegin.dayOfMonth().get())));
        System.out.print(" - ");
        System.out.println(dateTimeEnd.toString(PATTERN, Locale.US).replace("$$", formatDayOfMonth(dateTimeEnd.dayOfMonth().get())));
        System.out.println();
    }

    public static String formatDayOfMonth(int dayOfMonthIndex) {
        String suffix;

        switch ((dayOfMonthIndex < 20) ? dayOfMonthIndex : dayOfMonthIndex % 10) {
            case 1:
                suffix = "st";
                break;
            case 2:
                suffix = "nd";
                break;
            case 3:
                suffix = "rd";
                break;
            default:
                suffix = "th";
                break;
        }

        return dayOfMonthIndex + suffix;
    }

}