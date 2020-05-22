@Component
public class SummaryCache {
   private Map<String, Integer> summaryMap = new Hashmap<>();

   public void addValue(String id, Integer value) { 
       summaryMap.merge(id, value, (curVal, toAddVal) -> curVal.int() + toAddVal.int());

   }   
}