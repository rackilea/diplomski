package application;

    import java.text.ParseException;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.stream.Collectors;

    public class T {
        public static void main(String[] args) throws ParseException {
            List<String> list = Arrays.asList("A", "B", "C", "D", "B");
            Map<String, List<String>> map = new HashMap<>();
            list.forEach(ele->{
                List<String> innerList= new ArrayList<>();
                if(map.containsKey(ele)){
                    innerList = map.get(ele);
                }
                innerList.add(ele);
                map.put(ele, innerList);
            });
            List<List<String>> valueList = map.values().stream().collect(Collectors.toList()); 
            System.out.println(valueList);
        }
    }