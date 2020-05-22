import java.time.*;


class DateCheckSample {
    public static void main(String[] args) {

        // Our input date
        long millis = System.currentTimeMillis();

        // Convert the millis to a LocalDate
        Instant instant = Instant.ofEpochMilli(millis);
        LocalDate inputDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        // Grab today's date
        LocalDate todaysDate = LocalDate.now();

        System.out.println(millis);

        // Check if date is yesterday
        if (todaysDate.minusDays(1).equals(inputDate)) {
            System.out.println(inputDate + " was yesterday!");
        } else {
            System.out.println(inputDate + " was NOT yeseterday!");
        }
    }
}