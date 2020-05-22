public class Foo {
   private final Provider<Bar> defaultProvider;
   private final Map<Integer, Provider<Bar>> barTypeMap;

   private int var = -1;

   @Inject public Foo(Provider<Bar> defaultProvider, 
                      Map<Integer, Provider<Bar>> barTypeMap) {
     this.defaultProvider = defaultProvider;
     this.barTypeMap = barTypeMap;
   }

   public void setVar(int var) { ... }

   public Bar getBar() {
     if(barTypeMap.containsKey(var)) {
       return barTypeMap.get(var).get();
     }

     return defaultProvider.get();
   }
}