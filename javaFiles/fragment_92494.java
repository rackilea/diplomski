package test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Test {

    List<String> stringList = new ArrayList<String>();
    List<Integer> integerList = new ArrayList<Integer>();

    public static void main(String... args) throws Exception {
        Field stringListField = Test.class.getDeclaredField("stringList");
        ParameterizedType stringListType = (ParameterizedType) stringListField.getGenericType();
        Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
        System.out.println(stringListClass); // class java.lang.String.

        Field integerListField = Test.class.getDeclaredField("integerList");
        ParameterizedType integerListType = (ParameterizedType) integerListField.getGenericType();
        Class<?> integerListClass = (Class<?>) integerListType.getActualTypeArguments()[0];
        System.out.println(integerListClass); // class java.lang.Integer.
    }
}