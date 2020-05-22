import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Repeat {

    public static String text;
    static String vector = "";

    public static void main(String[] args) throws IOException {
        String line = "اهلا وسهلاااا بكمم!!";
        List<String> vals = new ArrayList<>();
        vals.add("ا");
        vals.add("ب");
        vals.add("ت");
        vals.add("ث");
        vals.add("ج");
        vals.add("ح");
        vals.add("خ");
        vals.add("د");
        vals.add("ذ");
        vals.add("ر");
        vals.add("ز");
        vals.add("س");
        vals.add("ش");
        vals.add("ص");
        vals.add("ض");
        vals.add("ط");
        vals.add("ظ");
        vals.add("ع");
        vals.add("غ");
        vals.add("ف");
        vals.add("ق");
        vals.add("ك");
        vals.add("ل");
        vals.add("م");
        vals.add("ن");
        vals.add("ه");
        vals.add("و");
        vals.add("ي");
        vals.add("!");
        vals.add("?");
        vals.add(".");
        vals.add(",");

        List<Integer> results = new ArrayList<>(vals.size());

        for (int i = 0; i < vals.size(); i++) {
            results.add(0);
        }

        for (int i = 0; i < line.length(); i++) {
            String s = "" + line.charAt(i);
            for (int j = 0; j < vals.size(); j++) {
                if (i < line.length() - 1) {
                    if (vals.get(j).equals(s) && vals.get(j).equalsIgnoreCase("" + line.charAt(i + 1))) {
                        results.set(j, results.get(j) + 1);
                    }
                }

            }

        }

        System.out.println(results);

    }

}