public static void main(final String[] args) {

    new ClassPathXmlApplicationContext("classpath:beans.xml");

    System.out.println("my.key: "+System.getProperty("my.key"));
    System.out.println("my.key2: "+System.getProperty("my.key2"));
    System.out.println("my.key3: "+System.getProperty("my.key3"));

    // to test that we're not overwriting existing properties
    System.out.println("java.io.tmpdir: "+System.getProperty("java.io.tmpdir"));
}