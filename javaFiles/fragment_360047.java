public class genericTest {
    public static void main(String[] args) {
        genericTest genericTest = new genericTest();
        genericTest.setValue(new BigDecimal("10".toString()));
        genericTest.setValue(new Date(0));

    }

    public <T> void setValue(T element) {
        if (element instanceof Date) {
            check((Date) element);
        }

        if (element instanceof BigDecimal) {
            check((BigDecimal) element);
        }
    }

    public void check(Date localDate) {
        System.out.println("This is Date metho, Caller has casted T to Date " + localDate);
    }

    public void check(BigDecimal localBigDecimal) {
        System.out.println("This is BigDecimal method, Caller has casted T to BigDecimal: " + localBigDecimal);
    }
}