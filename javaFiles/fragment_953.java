class Special {
    private StringBuilder s = new StringBuilder("bob"); 
    StringBuilder getName() { return new StringBuilder(s); } // return a copy of s
    void printName() { System.out.println(s); } 
}
public class TestSpecial {
    public static void main (String[] args ) {
        Special sp = new Special();
        StringBuilder s2 = sp.getName();
        s2.append("fred");
        sp.printName(); // prints "bob"
    }
}