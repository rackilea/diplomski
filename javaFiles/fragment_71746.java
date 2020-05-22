import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

String json1 = "[{\"Name\":\"Ronald\",\"Firstname\":\"Reagan\"},{\"Name\":\"Chris\",\"Firstname\":\"Jeoff\"}]";
JsonElement json = new JsonParser().parse(json1);
JsonArray array= json.getAsJsonArray();    
Iterator iterator = array.iterator();    
while(iterator.hasNext()){

JsonElement json2 = (JsonElement)iterator.next();

Gson gson = new Gson();
GetResult gresult = gson.fromJson(json2, GetResult.class);
System.out.println("Name:" + gresult.getName());
System.out.println("FirstName:" + gresult.getFirstname());