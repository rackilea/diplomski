public class StringPrinter {

    private StringMakerInterface stringMaker;

    public StringMakerInterface getStringMaker() {
        return stringMaker;
    }

    public void setStringMaker(StringMakerInterface stringMaker) {
        this.stringMaker = stringMaker;
    }

    public StringPrinter() {

    }

    // Just print dummy string, returned by implementation
    public void printString() {
        System.out.println(stringMaker.returnDummyString());
    }
}