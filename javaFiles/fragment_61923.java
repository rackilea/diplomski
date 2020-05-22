import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> map;
        List<Object> list = new ArrayList<Object>();
        for (int i = 1; i < 6; i++) {
            map = new HashMap<String, Object>();
            map.put("1", i);
            list.add(map);
        }
        System.out.println("list:" + list);
    }
}