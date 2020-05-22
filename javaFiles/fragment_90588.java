import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
...
Gson gson = new GsonBuilder().setPrettyPrinting().create();
JsonParser jp = new JsonParser();
JsonElement je = jp.parse(json.toString());
String prettyJsonString = gson.toJson(je);
System.out.println(prettyJsonString);