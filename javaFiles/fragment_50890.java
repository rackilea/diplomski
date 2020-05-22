public class MyClass {

    private int integer;

    private String string;

    private char character;

    public MyClass(int integer, String string, char character) {
        this.integer = integer;
        this.string = string;
        this.character = character;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;

        if (!(obj instanceof MyClass))
            return false;

        MyClass myClass = (MyClass) obj;

        if (integer == myClass.integer && string.equals(myClass.string) && character == myClass.character)
            return true;
        else
            return false;
    }

}