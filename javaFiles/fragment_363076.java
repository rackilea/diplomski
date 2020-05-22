public class EnumTest {
    enum MyEnum {
        LITERAL;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(ValueGetter.getValues(MyEnum.class)));
    }
}