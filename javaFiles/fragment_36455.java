import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path; // or use java.io.File

class SomeTests {

    @Test
    void testFoo(@TempDir Path directory) {
        // do test...
    }

}