class X {
    int m = 1111; // 1st point visited

    // This is X's initializer block:
    {
        m = m++; // 2nd point visited: m's value is not changed, read below
        System.out.println(m);
    }
}

class Y extends X {
    // This is Y's initializer block:
    {
        System.out.println(methodOfY()); // 3rd and 5th point visited: 
                                         // 2220 is printed after
                                         // methodOfY() has been evaluated
    }

    int methodOfY() {
        return m-- + --m; // 4th point visited: m-- = 1111 (m = 1110),
                          // --m = 1109 (m = 1109), therefore 2220 is 
                          // returned
    }
}

public class MainClass {
    public static void main(String[] args) {
        Y y = new Y();
    }
}