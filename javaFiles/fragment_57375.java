package stackoverflow;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StackOverflow {

    public static void main(String[] args) throws Exception {
        List<String> temp = new ArrayList(Arrays.asList("aaa", "123", "abc", "123", "456",
                "678", "abc", "xyz", "tyh", "479", "572", "4891", "asx", "abc",
                "4r65", "abc", "xg", "5684"));
        List<List<String>> newTemp = new ArrayList();

        for (String tmp : temp) {
            // Start a new sublist
            if (tmp.contentEquals("abc")) {
                newTemp.add(new ArrayList());
            }

            // Add to the newest sublist
            if (newTemp.size() > 0) {
                newTemp.get(newTemp.size() - 1).add(tmp);
            }
        }

        for (List<String> list : newTemp) {
            System.out.println(list);
        }
    }
}