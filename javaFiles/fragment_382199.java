public class Foo {
    public static void main(String []args) {
        Newfile.te = "Nothing";
        System.out.println(Newfile.te);
        System.out.println(Newfile.getTf());
    }
}

public class Newfile {
    public static String te = "Mango";

    // instead of using this public static String tf= Newfile.te + " Eating";

    public static String getTf() {
        return Newfile.te + " Eating";
    }
}