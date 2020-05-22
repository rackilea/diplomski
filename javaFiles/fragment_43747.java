import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Combin {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final String[][] array = new String[][] {
            new String[] {"red","green","blue"}
            , new String[] {"bold"}
            , new String[] {"underline"}
        };

        final List<String> list = combination(Arrays.asList(array));

        list.stream()
        .forEach(
            System.out::println
        )
        ;
    }

    static List<String> combination(
            final List<String[]> array)
    {
        if(array == null || array.size() < 1) {
            return Collections.<String>emptyList();
        }

        if(array.size() == 1) {
            return Arrays.stream(array.get(0))
                    .collect(Collectors.toList())
                    ;
        }

        if(array.size() == 2) {
            List<String> list1 = Arrays.stream(array.get(0))
                                .collect(Collectors.toList())
                                ;

            List<String> list2 = Arrays.stream(array.get(1))
                                .collect(Collectors.toList())
                                ;

            final List<String> list3 = new ArrayList<>();
            list1.stream()
            .forEach(
                s1 -> {
                    list2.stream()
                    .forEach(
                        s2 -> {
                            list3.add(s1 + ", " + s2);
                        }
                    );
                }
            )
            ;

            final List<String> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            list.addAll(list3);

            return list;
        }

        //length > 2
        List<String> list = combination(array.subList(0, 2));

        for(int i=2; i<array.size(); i++) {
            List<String[]> newArrayList = new ArrayList<>();
            newArrayList.add(list.toArray(new String[list.size()]));
            newArrayList.add(array.get(i));

            list = combination(newArrayList);
        }

        return list;

    }
}