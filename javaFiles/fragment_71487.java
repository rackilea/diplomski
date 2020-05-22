@BeforeClass
public static void setUp() throws Exception {
    new Thread(() -> {
        try {
            MyApplication.grizzlyServerSetup();
        } catch (IOException e) {
            e.printStackTrace();
        }).run();
}