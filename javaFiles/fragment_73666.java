import static org.junit.Assert.*;
import lombok.Builder;
import lombok.Value;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class ImmutableAnimals {

    @Builder(builderMethodName = "dogBuilder")
    public static Dog newDog(String color, String barkSound) {
        return new Dog(color, barkSound);
    }

    @Builder(builderMethodName = "catBuilder")
    public static Cat newCat(String color, String meowSound) {
        return new Cat(color, meowSound);
    }

    public static interface Animal {
        String getColor();
    }

    @Value
    public static class Cat implements Animal {
        String color;
        String meowSound;
    }

    @Value
    public static class Dog implements Animal {
        String color;
        String barkSound;
    }

    @Test
    public void testDog() {
        final String expectedBarkSound = "woof";
        final String expectedColor = "brown";

        final Dog dog = Animals.dogBuilder()
            .barkSound(expectedBarkSound)
            .color(expectedColor)
            .build();

        assertEquals(expectedBarkSound, dog.getBarkSound());
        assertEquals(expectedColor, dog.getColor());
    }

    @Test
    public void testCat() {
        final String expectedMeowSound = "purr";
        final String expectedColor = "white";

        final Cat cat = Animals.catBuilder()
            .meowSound(expectedMeowSound)
            .color(expectedColor)
            .build();

        assertEquals(expectedMeowSound, cat.getMeowSound());
        assertEquals(expectedColor, cat.getColor());
    }
}