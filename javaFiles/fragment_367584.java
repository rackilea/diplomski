try {
    InputStream fileStream = new FileInputStream(new File(
            "test.properties"));
    Properties props = new Properties();
    props.load(fileStream);
    String myPropValue = (String) props.get("test.prop");
    System.out.println(myPropValue);
} catch (FileNotFoundException e) {
} catch (IOException e) {
}