interface Encodable {
    Integer getCode();
}

public static <T extends Enum<T> & Encodable> T getValueOf(Class<T> enumClass, Integer code) {
    for (T e : enumClass.getEnumConstants()) {
        if (e.getCode().equals(code)) {
            return e;
        }
    }
    throw new IllegalArgumentException("No enum const " + enumClass.getName() + " for code \'" + code
            + "\'");
}

...

public enum MyEnum implements Encodable {
    ...
}

MyEnum e = getValueOf(MyEnum.class, 10);