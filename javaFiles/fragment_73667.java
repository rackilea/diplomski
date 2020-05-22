import static org.junit.Assert.*;
import lombok.Builder;
import lombok.Data;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class MutableAnimals {

    @Builder(builderMethodName = "dogBuilder")
    public static Dog newDog(String color, String barkSound) {
        final Dog dog = new Dog();
        dog.setBarkSound(barkSound);
        dog.setColor(color);
        return dog;
    }

    @Builder(builderMethodName = "catBuilder")
    public static Cat newCat(String color, String meowSound) {
        final Cat cat = new Cat();
        cat.setMeowSound(meowSound);
        cat.setColor(color);
        return cat;
    }

    public static interface Animal {
        String getColor();
    }

    @Data
    public static class Cat implements Animal {
        String color;
        String meowSound;
    }

    @Data
    public static class Dog implements Animal {
        String color;
        String barkSound;
    }

    @Test
    public void testDog() {
        final String expectedBarkSound = "woof";
        final String expectedColor = "brown";

        final Dog dog = MutableAnimals.dogBuilder()
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

        final Cat cat = MutableAnimals.catBuilder()
            .meowSound(expectedMeowSound)
            .color(expectedColor)
            .build();

        assertEquals(expectedMeowSound, cat.getMeowSound());
        assertEquals(expectedColor, cat.getColor());
    }
}