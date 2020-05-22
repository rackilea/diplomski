public class A {
    public String getLetter() {
        return "A";
    }
}
public class B {
    public String getLetter() {
        return "B";
    }
}

public class MainActivity {


    private int config = 0;

    public void onCreate(Bundle savedInstanceState) {


        String letter="";
        if (config == 0) {
            A myObject = new A();
            letter = myObject.getLetter();
        } else {
           B myObject = new B();
             letter = myObject.getLetter();
        }


    }
}