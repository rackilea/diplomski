import java.util.ArrayList;

public class SplitArray {
    private static ArrayList<String> list = new ArrayList<String>();

    public static ArrayList<String> split(String input, int splitSize) {
        int place = 0;

        for (int i = 0; i < input.length() / splitSize; i++) {
            String part = input.substring(place, place + splitSize);

            list.add(part);

            place += splitSize;
        }
        return list;
    }

    public static void main(String[] args) {
        String input = "aabbcc";
        split(input, 2);
    }
}