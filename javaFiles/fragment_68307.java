import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class TabSerializer {
    private static void addValuesFromMap(Map<?,?> obj, StringJoiner joiner) {
        for(Object key: obj.keySet()){
            Object value = obj.get(key);
            if(value == null){
                continue;
            }
            addValue(key, joiner);
            addValue(value, joiner);
        }
    }

    private static void addValuesFromList(List<?> arr, StringJoiner joiner) {
        for(int i=0; i<arr.size(); i++){
            Object value = arr.get(i);
            addValue(value, joiner);            
        }
    }

    public static void addValue(Object value, StringJoiner joiner){
        if(value == null){
            return;
        }
        if(value instanceof List){
            addValuesFromList((List<?>)value, joiner);
        }else if(value instanceof Map){
            addValuesFromMap((Map<?,?>)value, joiner);
        }else if(value instanceof TabSerializable){
            joiner.add(((TabSerializable) value).toTabbedString());
        }else{
            joiner.add(String.valueOf(value));

        }
    }
}