Intersection key = new Intersection(8, 42);
...
Integer count = hashMap.get(key);
if (count == null) {
   hashMap.put(key, 1);
} else {
   hashMap.put(key, value + 1);
}
...
public class Intersection {
   // these fields can't be changed
   private final int avenue;
   private final int street;
   ...