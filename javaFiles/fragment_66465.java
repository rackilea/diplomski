enum ABEnum {

    A, B;

    public static ABEnum fromString(String enumStr) {
        return ABEnum.valueOf(enumStr);
    }
}

public static Enum fromString(Enum seed, String enumStr) throws Exception {
    Class declaringClass = seed.getDeclaringClass();
    Method fromStringMethod = declaringClass.getDeclaredMethod("fromString", String.class);
    Object result = fromStringMethod.invoke(null, enumStr);
    return (Enum) result;
}

public void test() throws Exception {
    Enum e = fromString(ABEnum.A, "B");
    System.out.println(e);
}