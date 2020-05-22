public interface ItemWrapper {
    int calculateSomething();
}

public abstract class IntWrapper implements ItemWrapper {
    private int value;

    public IntWrapper(int v) {
      value=v; 
    }

    public int calculateSomething() {
      return value;
    }
}

public abstract class DoubleListWrapper implements ItemWrapper {
    private List<Double> list;

    public DoubleListWrapper (List<Double> lst) {
      list = lst; 
    }

    public int calculateSomething() {
        int res;
        for (Double d : list) {
            res += d;
        }

        return res;
    }
}
// ...and so on