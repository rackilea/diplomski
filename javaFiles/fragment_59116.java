import java.util.ArrayList;
public class Test extends ArrayList<Pair<String, Integer>>{

    public Integer get(String value){
        for (Pair<String, Integer> item : this){
            if (item.getKey().equals(value)){
                return item.getValue();
            }
        }
        return null;
    }

}