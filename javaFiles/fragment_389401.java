public class BitPositionDictionary {
     private Map<String,Integer> positions = new HashMap<String,Integer>();
     private int nextPosition;
     public int getPosition(String s) {
         Integer i = positions.get(s);
         if(i == null) {
             i = nextPosition;
             positions.put(i,s);
             nextPosition++;
         }
         return i;
     }
 }