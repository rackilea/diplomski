public class MyTree {
  private final Map<Double, Map<Double, Map<Integer, Data>>> data;

  public MyTree() {
    data = new DefaultMap<>(new Generator<Map<Double, Map<Integer, Data>>>() {
      @Override
      Map<Double, Map<Integer, Data>> create() {
        return new DefaultMap<>(new Generator<Map<Integer, Data>>() {

          @Override
          Map<Integer, Data> create() {
            return new TreeMap<>();
          }

        });
      }
    });
  }

  void add(MyKey d, Data obj) {
    data.get(d.beta).get(d.yaw).put(d.minute, obj);
  }
}