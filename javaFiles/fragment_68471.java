import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Test
{
    public static void main(String[] args)
    {
        Supplier<Test> supplier = () -> new Test();
        List<Test> list = Stream
            .generate(supplier)
            .limit(10)
            .collect(Collectors.toList());
        System.out.println(list.size()); // 10
        // Prints false, showing it really is calling the supplier
        // once per iteration.
        System.out.println(list.get(0) == list.get(1));
    }
}