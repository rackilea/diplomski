public class Main {
    //There is no reason to use public, final, or static on this int variable
    int a = 10;
    public static void main(String[] args) {
        //Cannot print a, as main is a static method and a is out of it's scope
        //System.out.println(a);

        //Creates new "Main" object, calls hai method
        Main m = new Main();
        m.hai();
    }

    public void hai() {
        int b = 1;
        System.out.println(b);
    }
}