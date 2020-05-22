class InternTest {
    // assuming InternTest is the only class, internPool.size = 0
    String x = "ABC"; // interned at class load, internPool.size = 1
    String y = "DEF"; // interned at class load, internPool.size = 2
    String z = "ABC"; // interned at class load, but match found - size = 2 still

    void foo() {
        // random int is just a mechanism to get something that I know won't
        // be interned at loadtime - could have loaded from file or database too
        int i = (new java.util.Random()).nextInt(1000) + 100;
        int j = i;
        String s = String.valueOf(i); // not yet interned, size = 2 still
        String t = String.valueOf(j); // not yet interned, size = 2 still

        String sIntern = s.intern(); // manually interned, size = 3 now
        String tIntern = t.intern(); // manually interned, match found, size = 3 still

        System.out.println("equals: " + (s.equals(t))); // should be true
        System.out.println("== raw: " + (s == t)); // should be false, different variables
        System.out.println("== int: " + (sIntern == tIntern)); // should be true, from unique pool

       System.out.println("x and z: " + (x == z)); // should be true, interned at class load
    }

    public static void main(String[] args) {
        (new InternTest()).foo();
    }

}