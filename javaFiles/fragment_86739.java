package samplejava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleJava {
public static void main(String[] args) {
    String[][] twodarray = { { "grey", "value1", "beta"  },
                                { "r", "name", "gender" , "value", "Female"  },
                                { "r", "name", "gender", "value", "Male" },
                                { "r", "name", "exp", "value", "1" },
                                { "r", "name", "exp", "value", "2"  }, 
                                { "red", "value1", "alpha"  },
                                { "blue", "value2", "alpha"  }, 
                        };
    Map<List<String>, List<String>> groups;
    groups = Arrays.stream(twodarray).collect(Collectors.groupingBy(
            (String[] item)-> Arrays.asList(item).subList(0, item.length - 1),
            Collectors.mapping(
                    (String[] item)-> item[item.length - 1],
                    Collectors.toList())));
    String[][] result = groups.entrySet().stream()
            .map(entry -> Stream.concat(entry.getKey().stream(),
                                        entry.getValue().stream())
                    .toArray(String[]::new))
            .toArray(String[][]::new);
    for(String[] row: result) {
        System.out.println(Arrays.toString(row));
    }
}
}