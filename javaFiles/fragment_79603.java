class Outer {
    String name;
    public Outer(String name) {
        this.name = name;
    }

    public class Inner {
        public String toString() {
            return "I belong to " + Outer.this.name;
        }
    }

    void f() {
        System.out.println(new Inner());
    }

    void g(Outer a) { 
        System.out.println(a.new Inner());
    }
}

class Main {
    public static void main(String[] args) {
        Outer x = new Outer("x");
        Outer y = new Outer("y");
        x.f();
        x.g(y);      
    }
}