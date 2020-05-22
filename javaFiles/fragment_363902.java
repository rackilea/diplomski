public class Code {

    // many properties
    private String name;
    private String number;
    // ...

    // 1.
    final String NEWLINE_1 = "1" + System.getProperty("line.separator");
    final String NEWLINE_2;
    final String NEWLINE_3;

    // 2.
    {
        System.out.println("initializer block invoked before Constructor");

        NEWLINE_2 = "2" + System.getProperty("line.separator");
        // final initialization CAN be put here =(

        // Source = new StringBuffer();

        // many other commons new's ..
        // ...
    }

    Code() {
        System.out.println("default constructor");
        // NEWLINE_1 = "error";     can't do this
        // NEWLINE_2 = "error";     can't do this

        // 3.
        NEWLINE_3 = "3" + System.getProperty("line.separator");
    }

    Code(String name, int number) {
        // 4.
        this();
        System.out.println("constructor(name, number)");

        name = new String("Someting(name)");
        this.number = new String("Magic(number)");
    }

    public static void main(String[] args) {
        Code code_1 = new Code();
        System.out.println(code_1.NEWLINE_1 + ":" + code_1.NEWLINE_2 + ":" + code_1.NEWLINE_3);

        Code code_2 = new Code("crowne", 2);
        System.out.println(code_2.NEWLINE_1 + ":" + code_2.NEWLINE_2 + ":" + code_2.NEWLINE_3);
    }
}