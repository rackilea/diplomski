public class EnumTest {

    protected static <E extends Enum<E>> void enumValues(Class<E> enumData) {
        for (Enum<E> enumVal: enumData.getEnumConstants()) {  
            System.out.println(enumVal.toString());
        }  
    }

    public static enum TestEnum {
        ONE, TWO, THREE;
    }

    public static void main(String param [] ) {
        EnumTest.enumValues(EnumTest.TestEnum.class);
    }
}