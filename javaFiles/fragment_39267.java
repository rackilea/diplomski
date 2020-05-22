import java.util.*;
public class MultiMap {
    public static void main(String[] args) {
        String[] codes = {
            "A=1,2,3,4",
            "B=1,3,5,9",
            "C=2,5,7,8",
        };
        Map<String,Set<String>> map = new HashMap<String,Set<String>>();
        Set<String> dupes = new HashSet<String>();
        for (String code : codes) {
            String parent = code.split("=")[0];
            for (String child : code.split("=")[1].split(",")) {
                Set<String> set = map.get(child);
                if (set == null) {
                    map.put(child, set = new HashSet<String>());
                } else {
                    dupes.add(child);
                }
                set.add(parent);
            }
        }
        System.out.println(map);
        // {3=[A, B], 2=[A, C], 1=[A, B], 7=[C], 5=[B, C], 4=[A], 9=[B], 8=[C]}
        for (String child : dupes) {
            System.out.println(child + "=" + map.get(child));
        }
        // 3=[A, B]
        // 2=[A, C]
        // 1=[A, B]
        // 5=[B, C]     
    }
}