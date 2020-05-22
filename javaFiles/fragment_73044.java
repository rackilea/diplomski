import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    // Declare DateTimeFormatter with desired format
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    // Save current LocalDateTime into a variable
    LocalDateTime localDateTime = LocalDateTime.now();

    // Format LocalDateTime into a String variable and print
    String formattedLocalDateTime = localDateTime.format(dateTimeFormatter);
    System.out.println("Current Date: " + formattedLocalDateTime);

    //Get random amount of days between 5 and 10
    Random random = new Random();
    int randomAmountOfDays = random.nextInt(10 - 5 + 1) + 5;
    System.out.println("Random amount of days: " + randomAmountOfDays);

    // Add randomAmountOfDays to LocalDateTime variable we defined earlier and store it into a new variable
    LocalDateTime futureLocalDateTime = localDateTime.plusDays(randomAmountOfDays);

    // Format new LocalDateTime variable into a String variable and print
    String formattedFutureLocalDateTime = futureLocalDateTime.format(dateTimeFormatter);
    System.out.println("Date " + randomAmountOfDays + " days in future: " + formattedFutureLocalDateTime);
  }
}