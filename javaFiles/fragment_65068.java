import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Duplicates {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("2#3#1#0",
                                          "1#0#4#1",
                                          "9#2#5#0",
                                          "4#2#3#2",
                                          "1#1#2#1");
        List<Character> uniqueChars = new ArrayList<>();
        for (String s : list) {
            Character c0 = s.charAt(0);
            Character c4 = s.charAt(4);

            if (!uniqueChars.contains(c0)) {
                uniqueChars.add(c0);
            }
            if (!uniqueChars.contains(c4)) {
                uniqueChars.add(c4);
            }
        }

        System.out.println(uniqueChars.size());
    }
}