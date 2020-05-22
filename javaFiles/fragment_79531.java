import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String args[]) {

        String[] myFirstStringArray = new String[] { "INDIABULLS HOUSING FINANCE LTD.", "INDIABULLS REAL ESTATE LTD.", };
        try {
            List<String> wordList = Arrays.asList(myFirstStringArray);
            String title = "INDIABULLS HOUSING FINANCE Q2 NET UP 24% AT RS 555 CR";
            String[] titleWords = title.toUpperCase().split(" ");
            for (String word : titleWords) {
                boolean found = false;
                for (String list : wordList) {
                    if (list.contains(word)) {
                        System.out.println("Yes");
                        found = true;
                        break;
                    } else {
                        System.out.println("No");
                    }
                }
                if(found) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}