public class Test2 {    
  public static setWeakRef(Test1 instance, WeakReference weakRef) {
    Field[] fields = Test1.getDeclaredFields();

    for (Field field : fields) {
      if (field.getType().equals(WeakReference.class) {
        WeakReference value = (WeakReference) field.get(instance);
        if (value == weakRef) {
          System.out.println(field.getName());
        }
      }
    }
  }
}