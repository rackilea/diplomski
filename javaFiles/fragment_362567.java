import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class QuestionTest {
    @Test
    void example() {
        var input = List.of(
            new Version("dev-1.lan", List.of(
                new Job("a", "1.1.1"),
                new Job("b", "10.0.1"),
                new Job("c", "2.0.1")
            )),
            new Version("dev-2.lan", List.of(
                new Job("a", "1.1.1"),
                new Job("b", "10.0.1"),
                new Job("c", "2.0.1")
            )),
            new Version("dev-3.lan", List.of(
                new Job("a", "1.1.1"),
                new Job("b", "10.0.1"),
                new Job("c", "2.0.2")
            )),
            new Version("uk-1.lan", List.of(
                new Job("a", "1.1.1"),
                new Job("b", "10.0.0"),
                new Job("c", "2.0.2")
            )),
            new Version("uk-2.lan", List.of(
                new Job("a", "1.1.1"),
                new Job("b", "10.0.0"),
                new Job("c", "2.0.2")
            )),
            new Version("uk-3.lan", List.of(
                new Job("a", "1.1.1"),
                new Job("b", "10.0.0"),
                new Job("c", "2.0.2")
            )),
            new Version("uk-4.lan", List.of(
                new Job("a", "1.1.1"),
                new Job("b", "10.0.1"),
                new Job("c", "2.0.2")
            ))
        );

        var expectedOutput = Map.of(
            "a", Map.of(
                "DEV", Map.of(
                    "1.1.1", Set.of(1, 2, 3)
                ),
                "UK", Map.of(
                    "1.1.1", Set.of(1, 2, 3, 4)
                )
            ),
            "b", Map.of(
                "DEV", Map.of(
                    "10.0.1", Set.of(1, 2, 3)
                ),
                "UK", Map.of(
                    "10.0.0", Set.of(1, 2, 3),
                    "10.0.1", Set.of(4)
                )
            ),
            "c", Map.of(
                "DEV", Map.of(
                    "2.0.1", Set.of(1, 2),
                    "2.0.2", Set.of(3)
                ),
                "UK", Map.of(
                    "2.0.2", Set.of(1, 2, 3, 4)
                )
            )
        );

        var actualOutput = Main.parse(input);

        assertEquals(expectedOutput, actualOutput);
    }
}