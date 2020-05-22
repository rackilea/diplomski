import java.nio.file.*;
import java.util.*;

public class SortTest2 {

    public static void main(String[] args) throws Exception {
        Set<String> uniq = new HashSet<>(100000, 0.9f);
        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
            stream.forEach(uniq::add);
        }

        Files.write(Paths.get("./outfile2"), (Iterable<String>) uniq::iterator);
    }
}