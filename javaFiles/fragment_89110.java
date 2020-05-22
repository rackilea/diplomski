public class MyConstants {

    public static final LocalDateTime MINDATE 
            =  LocalDateTime.of(LocalDate.of(2011, 1, 1), LocalTime.MIDNIGHT);
    public static final DateTimeFormatter FORMATTER 
            = DateTimeFormatter.ofPattern("uuuu-MM-ddTHH:mm");

}