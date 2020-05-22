import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTests {
    static class Rule {
        final String id;
        final String name;
        final String description;

        Rule(String id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        // no equals, no hashCode
    }

    @Test
    void rulesShouldEqual_whenTheirPropertiesEqual() {
        Rule actualRule1 = new Rule("id1", "name1", "description1");
        Rule actualRule2 = new Rule("id2", "name2", "description2");
        List<Rule> actual = Arrays.asList(actualRule1, actualRule2);

        Assertions.assertThat(actual).usingFieldByFieldElementComparator().containsExactly(
                new Rule("id1", "name1", "description1"),
                new Rule("id2", "name2", "description2"));
    }
}