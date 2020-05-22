import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectToListOfList {
    static class Widget {
        String code;
        String name;

        Widget(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return code + ": " + name;
        }

    }

    public static void main(String[] args) {
        List<Widget> widgetList = Arrays.asList(
            new Widget("0", "A"), 
            new Widget("1", "B"), 
            new Widget("2", "C"),
            new Widget("3", "D"), 
            new Widget("0", "E"), 
            new Widget("1", "F"), 
            new Widget("2", "G"),
            new Widget("3", "H"), 
            new Widget("0", "I"), 
            new Widget("1", "J"));

        Collection<List<Widget>> result = widgetList.stream()
            .collect(Collectors.groupingBy(Widget::getCode, TreeMap::new, Collectors.toList()))
            .values();

        for (List<Widget> list : result) {
            System.out.println(list);
        }

    }
}