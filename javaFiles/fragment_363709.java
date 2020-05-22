import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TypeUniqueCollection extends ArrayList<Object> {
  private int classCount = 0;
  private Map<Class<?>, Integer> classesSeenOrder = new HashMap<Class<?>, Integer>();

  @Override
  public boolean add(Object o) {
    Class<?> c = o.getClass();
    Integer index = classesSeenOrder.get(c);
    if (index != null) {
      super.set(index, o);
    }
    else {
      classesSeenOrder.put(c, classCount++);
      super.add(o);
    }

    return true;
  }
}