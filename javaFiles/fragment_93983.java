import java.time.Duration;
class Main {
  public static void main(String[] args) {
    System.out.println("Using math");
    long millsMath = 93631000;

    long hoursMath = millsMath / 3600000;
    long minutesMath = (millsMath % 3600000) / 60000;
    long secondsMath = (millsMath % 60000) / 1000;

    String outMath = String.format("%02d:%02d:%02d",hoursMath, minutesMath, secondsMath);
    System.out.println(outMath);



    System.out.println("\nUsing Duration");
    Duration dur = Duration.ofMillis(93631000);

    long hoursDur   = dur.toHours();
    long minutesDur = dur.minusHours(hoursDur).toMinutes();
    long secondsDur = dur.minusHours(hoursDur).minusMinutes(minutesDur).getSeconds();

    String outDur = String.format("%02d:%02d:%02d", hoursDur, minutesDur, secondsDur);

    System.out.println(outDur);
  }
}