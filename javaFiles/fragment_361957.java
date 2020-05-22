import java.nio.Files;
import java.nio.Paths;
...
File.lines(Paths.get("/path/to/the/file"), StandardCharsets.ISO_8859_1)
//      .parallel() // parallel processing is still possible
        .forEach(line -> { /* your code goes here */ });