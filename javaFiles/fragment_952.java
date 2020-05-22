class Special {
    private String s = "bob"; 
    String getName() { return s; }
    void printName() { System.out.println(s); } 
}
public class TestSpecial {
    public static void main (String[] args ) {
        Special sp = new Special();
        String s2 = sp.getName();
        s2 += "fred";
        // Alternatively: StringBuilder s2 = new StringBuilder(sp.getName()).append("fred");
        sp.printName(); // prints "bob"
    }
}