import java.util.ArrayList;

public class Test {
    static ArrayList<String> list = new ArrayList<String>();
    static String[][] temp_list;

    public static void main(String[] args) {
        list.add("hello wold");

        // allocate memory for 10 string-arrays.
        temp_list = new String[10][];     <-----------

        String temp = list.get(0);
        temp_list[0] = temp.split(" ");
    }
}