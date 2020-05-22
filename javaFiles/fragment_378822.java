package demo;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        // ClassNotFoundException thrown when demo.Color does not exist
        Class<?> enumType = Class.forName("demo.Color");

        // constants is null when demo.Color is not an enum
        Object[] constants = enumType.getEnumConstants();

        System.out.println("is " + enumType + " an enum? " + enumType.isEnum());
        System.out.println(Arrays.toString(constants));
    }
}

enum Color {
    GREEN,
    BLUE
}