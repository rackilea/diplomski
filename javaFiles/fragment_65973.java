public class MyAwesomeJsonArray extends JacksonObject implements A {

   private final Set<MyAwesomeJson> values = Sets.newLinkedHashSet();

   public MyAwesomeJsonArray(MyAwesomeJson... values) {
     this.values.addAll(Arrays.asList(values));
   }

   @JsonValue
   public Set<MyAwesomeJson> getValues() {
     return values;
   }
}