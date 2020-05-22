public void testDonwloadUsingJava8() throws Exception {

    URL image = new URL("http://learning.es/blog/wp-content/uploads/2014/08/java.jpg");

    Path tempFile = Files.createTempFile("test-java8-", ".jpg");
    Files.copy(image.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

    System.out.println(tempFile.toString());
    System.out.println(tempFile.toFile().length());
}