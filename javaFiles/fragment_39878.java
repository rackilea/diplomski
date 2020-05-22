import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

class Animal {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + "]";
    }
}

class Dog extends Animal{
    @SerializedName("Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + ", Id=" + getId() + "]";
    }


}
public class GSonParser {

    public static void main(String[] args) throws Exception {
        String json = "{\"id\" : \"1\", \"Name\" : \"Fluffy\"}";
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        Gson gson = new Gson();
        Dog dog = gson.fromJson(jsonObject.toString(), Dog.class);
        System.out.println(dog); // Prints "Dog [name=Fluffy, Id=1]"
    }

}