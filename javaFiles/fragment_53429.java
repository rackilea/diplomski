public class Day implements Identifiable {
  private static AtomicInteger count = new AtomicInteger(0);
  private int id;
  private byte isHoliday;

  public Day() {
    this.id = count.incrementAndGet(); 
  }
}