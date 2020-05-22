public class MyObject {

    private static final DateTimeFormatter ARRIVAL_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Some instance variables
    private LocalTime arrivalTime;

    public MyObject(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFormattedArrivalTime() {
        return arrivalTime.format(ARRIVAL_TIME_FORMATTER);
    }

}