private static PrintStream ORIGINAL_OUT = null;

@BeforeClass
public static void interceptOut() {
    ORIGINAL_OUT = System.out;
}

@AfterClass
public static void revertOut() {
    System.setOut(ORIGINAL_OUT);
}