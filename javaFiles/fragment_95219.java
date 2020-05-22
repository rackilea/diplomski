import static org.junit.Assert.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import org.junit.Test;

public class So32989562DataTest {

    @Data
    public static class Parent {

        protected String nationality;

    }

    @Value
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class Child extends Parent {

        private final String firstName;

        private final String lastName;

        @Builder(toBuilder = true)
        private Child(String nationality, String firstName, String lastName) {
            this.setNationality(nationality);
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    @Test
    public void testChildBuilder() {

        String expectedFirstName = "Jeff";
        String expectedLastName = "Maxwell";
        String expectedNationality = "USA";

        Child result = Child.builder()
            .firstName(expectedFirstName)
            .lastName(expectedLastName)
            .nationality(expectedNationality)
            .build();

        assertEquals(result.toString(), expectedFirstName, result.getFirstName());
        assertEquals(result.toString(), expectedLastName, result.getLastName());
        assertEquals(result.toString(), expectedNationality, result.getNationality());
    }
}