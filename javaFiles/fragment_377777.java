@Test
public void testParse() throws IOException {
    for (File file : fileNames) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            String everyThing = IOUtils.toString(inputStream, "UTF-8");
            //do something
        }
    }
}