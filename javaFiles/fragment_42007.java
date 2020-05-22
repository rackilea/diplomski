public interface StringMakerInterface {

    // Just return simple String depending on concrete implementation.
    String returnDummyString();

}

public class StringMakerImpl1 implements StringMakerInterface {

    public String returnDummyString() {
        return "test bean impl 1";
    }


}

public class StringMakerImpl2 implements StringMakerInterface{

    public String returnDummyString() {
        return "test bean impl 2";
    }

}