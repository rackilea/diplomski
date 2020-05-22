package lombok.javac.handlers.stackoverflow;

import static org.junit.Assert.*;

import java.util.Random;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Tolerate;

import org.junit.Test;

public class So34241718 {

    @Builder
    @Data
    public static class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Setter(value = AccessLevel.PROTECTED)
        Long id;

        @Tolerate
        Person() {}

       /* IMPORTANT:
          Override toString, equals, and hashCode as described in these 
          documents:
          - https://vladmihalcea.com/the-best-way-to-implement-equals-hashcode-and-tostring-with-jpa-and-hibernate/
          - https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
          - https://vladmihalcea.com/hibernate-facts-equals-and-hashcode/
          */
    }

    @Test
    public void testPersonBuilder() {

        Long expectedId = new Random().nextLong();
        final Person fromBuilder = Person.builder()
            .id(expectedId)
            .build();
        assertEquals(expectedId, fromBuilder.getId());

    }

    @Test
    public void testPersonConstructor() {

        Long expectedId = new Random().nextLong();
        final Person fromNoArgConstructor = new Person();
        fromNoArgConstructor .setId(expectedId);
        assertEquals(expectedId, fromNoArgConstructor.getId());
    }
}