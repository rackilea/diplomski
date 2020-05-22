public class HeterogeneousContainer {
     private final Map<Class<? extends Content>, List<? extends Content>> map;

     public <T extends Content> void put(Class<T> type, List<T> values) {
         map.put(type, values);
     }


     public <T extends Content> List<T> get(Class<T> type) {
         //this warning can be safely suppressed after inspection
         return (List<T>) map.get(type); 
     }
 }