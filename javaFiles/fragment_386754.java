public class Record
{
      private HashMap<String, String> values;

      public Record()
      {
           // create your hashmap.
           values = new HashMap<String, String>();
      }

      public String getData(String key)
      {
           return values.get(key);
      }

      public void addData(String key, String value)
      { 
           values.put(key, value);
      }
}