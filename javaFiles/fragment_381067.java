@Before
public void setup() {
    fh = new FileHandler("test.log", true);
    formatter = new SimpleFormatter();
    fh.setFormatter(formatter); 
    logger.addHandler(fh);
}