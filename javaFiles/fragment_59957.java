package test;
import com.google.gson.Gson;
public abstract class JsonObject {
    @Override
    public String toString() {
          Gson gson = new Gson();
          return gson.toJson(this);
    }
    public Object toObject(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, this.getClass());
    }
}