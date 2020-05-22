package p;
enum enumA {
    A1,A2,A3;
}
enum enumB {
    B1,B2,B3;
}
enum enumC {
    C1,C2,C3;
}
class MyArray{
    MyArray(Class<? extends Enum> e1,Class<? extends Enum> e2,Class<? extends Enum> e3) {
        strings=new String[e1.getEnumConstants().length][e1.getEnumConstants().length][e2.getEnumConstants().length];
        e3.getEnumConstants();
    }
    void set(enumA a,enumB b,enumC c,String string) {
        strings[a.ordinal()][b.ordinal()][c.ordinal()]=string;
    }
    String get(enumA a,enumB b,enumC c) {
        return strings[a.ordinal()][b.ordinal()][c.ordinal()];
    }
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for(enumA a:enumA.values())
            for(enumB b:enumB.values()) {
                for(enumC c:enumC.values()) {
                    sb.append(get(a,b,c));
                    sb.append('\n');
                }
                sb.append('\n');
            }
        return sb.toString();
    }
    public static void main(String[] arguments) {
        MyArray myArray=new MyArray(enumA.class,enumB.class,enumC.class);
        for(enumA a:enumA.values())
            for(enumB b:enumB.values())
                for(enumC c:enumC.values())
                    myArray.set(a,b,c,""+a+b+c);
        System.out.println(myArray);
    }
    final String[][][] strings;
}