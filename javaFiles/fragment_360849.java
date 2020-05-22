import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Notepad {

    public static void main(String args[]) {
        final List<String> titles = new ArrayList<>();
        titles.add("miss | shannon sperling");
        titles.add("mr | john smith");
        titles.add("prof | kim taylor");
        titles.add("prof.dr | kim taylor");
        gluetitles(titles);
    }

    static void gluetitles(final List<String> titles) {
        final Map<String, String> titleMap = new HashMap<>();
        for (final String names : titles) {
            final String[] titleName = names.split("\\|");
            final String title = titleName[0];
            final String name = titleName[1];
            if (doesMapContainName(titleMap, title, name)) {
                titleMap.put(name, title);
            }
        }
        for (final Entry<String, String> s : titleMap.entrySet()) {
            System.out.println("Name is " + s.getKey() + " Title is "
                    + s.getValue());
        }
    }

    private static boolean doesMapContainName(
            final Map<String, String> titleMap, final String title,
            final String name) {
        return (titleMap.get(name) != null && titleMap.get(name).length() < title
                .length()) || !titleMap.containsKey(name);
    }
}