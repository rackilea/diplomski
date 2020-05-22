public class Response
{
    List<ResponseEntry> response;
    /*getters + setters */

    public static class ResponseEntry
    {
         private List<Value> elements;
         /*setters + getters*/

         public static class Value
         {
             private List<Object> val;
         }
    }
}