@Test
public void enumerateAllVariants() {
    //String regex = "[ab]{4,6}c";
    String regex = "34\\.25\\.14\\.(227|228|229|230|243|244|245|246)";
    Xeger generator = new Xeger(regex);
    generator.enumerate();
}