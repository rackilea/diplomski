package application;

    import java.text.ParseException;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.List;

    public class T {
        public static void main(String[] args) throws ParseException {
            List<String> list = Arrays.asList("A", "B", "C", "D", "B");
            HashMap<String, List<String>> map = new HashMap<>();
            List<List<String>> valueList = new ArrayList<>();
            list.stream().forEach(ele -> {
                List<String> innerList = new ArrayList<>();
                if (map.containsKey(ele)) {
                    innerList = map.get(ele);
                } else {
                    valueList.add(innerList);
                }
                innerList.add(ele);
                map.put(ele, innerList);
            });
            System.out.println(valueList);
        }

    }