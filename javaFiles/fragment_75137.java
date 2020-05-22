public class CustomMap {

      private Map<String, Object> _map;

      public CustomMap(){
         _map = new HashMap<String, Object>();  
      }  

      public <T> void setTypeValueByKey(Integer key, T value) {
         _map.put(key.toString(), value);
      }

      public <T> T getTypeValueByKey(Class<T> klass, Integer key) {
         return klass.cast(_map.get(key.toString()));
      }

      public static void main(String[] o){
         CustomMap map = new CustomMap();
         map.setTypeValueByKey(new Integer(1), new Spanned() );
         map.setTypeValueByKey(new Integer(2), new String("foo"));         

         Spanned spanned = 
           map.getTypeValueByKey(Spanned.class, new Integer(1));
         String foo = 
           map.getTypeValueByKey(String.class, new Integer(2));                  
      }

   static class Spanned{}
}