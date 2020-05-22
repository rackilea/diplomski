import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiValuedMap {


    private static Map<String,List<String>> storage = new HashMap<>();

    public static void main(String[] args) {

        store("Tom","Tom,schoolA,1402");
        store("TomschoolA","Tom,schoolA,1402");
        store("Tom","Tom,schoolB,1402");
        store("TomschoolB","Tom,schoolB,1403");

        storage.forEach((key,value) -> System.out.println("key:"+key+",value:"+value));

    }

    private static void store(String key, String value){

        if(storage.containsKey(key)) {
            List<String> newList = storage.get(key);
            newList.add(value);
            storage.put(key,newList);
        }else{
            List<String> values = new ArrayList<String>();
            values.add(value);
            storage.put(key,values);
        }

    }

}