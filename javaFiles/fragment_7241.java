enum MyEnum {

    A("1", "2", "3"), B("4", "5", "6");

    final String s1;
    final String s2;
    final String s3;

    private MyEnum(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
}

public class MyEnumExample {
    static String readThirdValue(String first, String second) {
        for (MyEnum e : MyEnum.values()) {
            if (e.s1.equals("1") && e.s2.equals("2")) {
                return e.s3;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String thirdValue = readThirdValue("1", "2");
        if (thirdValue == null) {
            System.out.println("no matching enum found");
        } else {
            System.out.println("found " + thirdValue);
        }
    }
}