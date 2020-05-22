import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Iterator {

    private static List<String> someList = new ArrayList<String>();

    public static void main(String[] args) {
        someList.add("monkey");
        someList.add("donkey");

        for (Iterator<String> i = someList.iterator(); i.hasNext();) {
            String item = i.next();
            System.out.println(item);
        }
    }
}