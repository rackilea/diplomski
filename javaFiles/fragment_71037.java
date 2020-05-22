public class Computation<T> {
   private T value;
   private Set<Computation<?>> usedBy;

   public T getValue(Computation<?> getter) {
     if (usedBy == null) {
       // value was not computed
       value = compute();
       usedBy = new HashSet();
     }
     if (getter != null) {
       // add a dependency
       usedBy.add(getter);
     }
     return value;
   }

   protected T compute() {
     // override when needed a lazily-computed value
     return null;
   }

   public void setValue(T value) {
     // invalidate this value
     invalidate();
     // set the new value
     this.value = value;
     usedBy = new HashSet();
   }

   public void invalidate() {
     if (usedBy != null) {
       for (Computation<?> c : usedBy) {
         c.invalidate();
       }
       usedBy = null;
     }
     value = null;
   }
}

public class Business {
  private Computation<Integer> a = new Computation<Integer>();
  private Computation<Integer> b = new Computation<Integer>();
  private Computation<Integer> c = new Computation<Integer>() {
    public Integer compute() {
      return a.getValue(this) + b.getValue(this);
    }
  };

  public void setA(int v) {
    a.setValue(v);
  }
  public void setB(int v) {
    b.setValue(v);
  }
  public int getC() {
    return c.getValue(null);
  }
}