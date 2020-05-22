public class DirectoryWatcher{

   private static Map<String,String> properties = new HashMap<String,String>();

   public static synchronized getValueFor(String prop){
       String result = null;
       if( !properties.keySet().contains(prop)){
          result = // your loading code
          properties.put(prop, result);
       }else{
          result = properties.get(prop);
       }
       return result;
    }
}