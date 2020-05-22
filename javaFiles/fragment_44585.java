import java.util.Random;

import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class Performance extends SimpleBenchmark {
  static final Random rnd = new Random();

  public int timeDecrementToZero(int reps) {
    int sum = rnd.nextInt();
    for (int i = 0; i < reps; i++) {
      for (int j = Integer.MAX_VALUE; j >= 0; j--) sum += j;
    }
    return sum;
  }
  public int timeDecrementFromZero(int reps) {
    int sum = rnd.nextInt();
    for (int i = 0; i < reps; i++) {
      for (int j = 0; j > Integer.MIN_VALUE; j--) sum += j;
    }
    return sum;
  }
  public int timeIncrementFromZero(int reps) {
    int sum = rnd.nextInt();
    for (int i = 0; i < reps; i++) {
      for (int j = 0; j < Integer.MAX_VALUE; j++) sum += j;
    }
    return sum;
  }
  public int timeIncrementToZero(int reps) {
    int sum = rnd.nextInt();
    for (int i = 0; i < reps; i++) {
      for (int j = Integer.MIN_VALUE; j < 0; j++) sum += j;
    }
    return sum;
  }

  public static void main(String... args) {
    Runner.main(Performance.class, args);
  }
}