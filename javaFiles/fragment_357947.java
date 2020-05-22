InputStream is = getClass().getResourceAsStream("/htmls/myhtml.html");
// and then read with the help of variety of ways, depending on Java Version of your choice and by the availaility by auxiliary thirdparties

// here is the most simple way IMO for Java 9+ 

String htmlString = new String(input.readAllBytes(), StandardCharsets.UTF_8);