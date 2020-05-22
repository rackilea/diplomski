public static void main(String...a) throws URISyntaxException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    URI url = new URI("https://pmi_artifacts_prod.s3.amazonaws.com");
    System.out.println(url.getHost()); //NULL


    URI uriObj = new URI("https://pmi_artifacts_prod.s3.amazonaws.com");
    if (uriObj.getHost() == null) {
        final Field hostField = URI.class.getDeclaredField("host");
        hostField.setAccessible(true);
        hostField.set(uriObj, "pmi_artifacts_prod.s3.amazonaws.com");
    }
    System.out.println(uriObj.getHost()); //pmi_artifacts_prod.s3.amazonaws.com


    URI url2 = new URI("https://s3.amazonaws.com");
    System.out.println(url2.getHost());  //s3.amazonaws.com
}