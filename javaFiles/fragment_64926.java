package com.stackoverflow.SO34299054;

import static org.junit.Assert.*;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.junit.Test;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("javadoc")
public class Answer {

    @Entity
    @Builder(toBuilder = true)
    @AllArgsConstructor(access = AccessLevel.PACKAGE)
    @NoArgsConstructor(access = AccessLevel.PACKAGE)
    @Setter(value = AccessLevel.PACKAGE)
    @Getter
    public static class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        /*
         * IMPORTANT:
         * Set toString, equals, and hashCode as described in these
         * documents:
         * - https://vladmihalcea.com/the-best-way-to-implement-equals-hashcode-and-tostring-with-jpa-and-hibernate/
         * - https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
         * - https://vladmihalcea.com/hibernate-facts-equals-and-hashcode/
         */
    }

    /**
     * Test person builder.
     */
    @Test
    public void testPersonBuilder() {

        final Long expectedId = new Random().nextLong();
        final Person fromBuilder = Person.builder()
            .id(expectedId)
            .build();
        assertEquals(expectedId, fromBuilder.getId());

    }

    /**
     * Test person constructor.
     */
    @Test
    public void testPersonConstructor() {

        final Long expectedId = new Random().nextLong();
        final Person fromNoArgConstructor = new Person();
        fromNoArgConstructor.setId(expectedId);
        assertEquals(expectedId, fromNoArgConstructor.getId());
    }
}