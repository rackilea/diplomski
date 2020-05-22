import javax.json.Json;
import javax.json.stream.JsonParser;

...

String dataPath = "data.json";

try(JsonParser parser = Json.createParser(new FileReader(dataPath))) {
     List<String> row = new ArrayList<>();

     while(parser.hasNext()) {
         JsonParser.Event event = parser.next();
         switch(event) {
             case START_ARRAY:
                 continue;
             case VALUE_STRING:
                 row.add(parser.getString());
                 break;
             case END_ARRAY:
                 if(!row.isEmpty()) {
                     //Do something with the current row of data 
                     System.out.println(row);

                     //Reset it (prepare for the new row) 
                     row.clear();
                 }
                 break;
             default:
                 throw new IllegalStateException("Unexpected JSON event: " + event);
         }
     }
}