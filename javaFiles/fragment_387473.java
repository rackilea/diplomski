package example; 

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main (String[] args) {
        List<MyEnum> enums = new ArrayList<MyEnum>();
    }

    enum MyEnum { ONE, TWO, THREE;}
    //         no need for that  ^ but added to match your question
}