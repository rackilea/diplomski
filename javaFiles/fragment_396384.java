import java.util.NavigableMap;
import java.util.TreeMap;
import static java.util.concurrent.ThreadLocalRandom.current;

final class LoadedDie {

  public static void main(String... argv) {
    NavigableMap<Integer, String> loot = new TreeMap<>();
    int cumulative = 0;
    loot.put(cumulative += 20, "Gold");
    loot.put(cumulative += 30, "Iron");
    loot.put(cumulative += 50, "Coal");

    /* Use */
    System.out.println(loot.higherEntry(current().nextInt(cumulative)).getValue());
    System.out.println(loot.higherEntry(current().nextInt(cumulative)).getValue());
  }

}