import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Demo {
  public static void main(String[] args) throws InterruptedException, IOException {

    int i = 0;
    int j;

    while (i <= 100) {
      System.out.print("\033[H\033[2J");
      j = 0;
      for (j = 0; j < i; j++) {
        System.out.print('■');
      }
      for (; j <= 100; j++) System.out.print(' ');
      System.out.print(i + "%");
      TimeUnit.SECONDS.sleep(1);
      i += 2;
    }
  }
}