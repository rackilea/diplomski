public class SampleClass {
    public static void main(String[] args) {
        System.out.println(SubClass.ID);
        System.out.println(SubClass.i);
    }
}

class Super {
    static String ID = "SUPER_ID";
}

class SubClass extends Super {
    static {
        System.out.println("In SubClass");
    }

    static int i;
}

Output :
SUPER_ID
In SubClass // only when accessing a variable of subclass, the class will be initialized.
0