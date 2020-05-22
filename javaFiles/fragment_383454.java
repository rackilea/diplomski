import java.text.NumberFormat;

class MyClass {

    void someMethod() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        // ...
    }
}