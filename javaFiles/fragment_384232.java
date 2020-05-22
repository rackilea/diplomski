import java.nio.file.*;
import java.util.stream.*;

public class SortTest3 {

    public static void main(String[] args) throws Exception {
        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
            Files.write(Paths.get("./outfile3"), (Iterable<String>) stream.distinct()::iterator);
        }
    }
}