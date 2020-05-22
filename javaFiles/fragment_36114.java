public class ParameterPassing {
    public static void setParams(Integer value1, Integer value2) {
        System.out.println("value1 before: " + value1);
        System.out.println("value2 before: " + value2);
        value1 = new Integer(1);
        value2 = new Integer(2);
        System.out.println("value1 after: " + value1);
        System.out.println("value2 after: " + value2);
    }

    public static void main(String[] args) {
        Integer valNull = null;
        Integer val0 = new Integer(0);
        System.out.println("valNull before: " + valNull);
        System.out.println("val0 before: " + val0);

        setParams(valNull, val0);

        System.out.println("valNull after: " + valNull);
        System.out.println("val0 after: " + val0);
    }
}