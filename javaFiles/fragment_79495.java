package stackoverflow.questions;

import java.util.*;

import com.google.gson.*;

public class Q20883087 {

  public static JsonElement get(JsonElement je, String...  args){
     if(args.length == 0)
        return je;

     if (je != null && je.isJsonObject()){
        String[] newArgs = Arrays.copyOfRange(args, 1, args.length);
       return get(je.getAsJsonObject().get(args[0]), newArgs); 
     }


   }

   public static void main(String[] args) {
      String json ="{                          "+
      "   \"hello\": {            "+
      "     \"bye\": {            "+
      "      \"a\": \"1\",        "+
      "       \"b\": \"2\",       "+
      "       \"c\": \"3\"        "+
      "     },                    "+
      "     \"d\": \"4\",         "+
      "     \"e\": \"5\"          "+
      "   },                      "+
      "   \"hey\": {              "+
      "    \"qwer\": {            "+
      "       \"asdf\": \"1\",    "+
      "       \"fda\": \"2\",     "+
      "       \"bc\": \"3\"       "+
      "     },                    "+
      "     \"dq\": \"4\"         "+
      "   }                       "+
      "  }                        ";

      JsonElement jsonElement = new JsonParser().parse(json);

      System.out.println(get(jsonElement, "hello","bye"));
      System.out.println(get(jsonElement, "hey","qwer"));




   }

}