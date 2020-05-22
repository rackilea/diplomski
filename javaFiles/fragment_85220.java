import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

class DataObject<T> {

    private List<String> list = new ArrayList<String>() {
        {
            add("String 1");
            add("String 2");
            add("String 3");
        }
    };
    private int data1 = 100;
    private String data2 = "hello";
    DataObject child;
    private Map<String, T> data = null;

    public DataObject(int i) {
        this.data1 = i;
        this.data = new HashMap<String, T>();
    }

    // getter and setter methods

    @Override
    public String toString() {
        return "DataObject [data1=" + data1 + ", data2=" + data2 + ", list=" + list + "]";
    }

    public Map<String, T> getData() {
        return data;
    }

    public void addData(final String key, T value) {
        data.put(key, value);
    }
}

public class test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DataObject obj = new DataObject(12);
        obj.child = new DataObject(25);
        obj.addData("myOtherData", new DataObject(32));
        Gson gson = new Gson();
        System.out.println(gson.toJson(obj));
    }

}