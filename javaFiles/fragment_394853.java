public class Report {

  private final List<Producer> producers = new ArrayList<>();

  public void addProducer(Producer producer) {
    producers.add(producer);
  }

  public void produce() {
    producers.forEach((p) -> p.produce());
  }

}