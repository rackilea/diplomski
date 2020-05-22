XMxmlParser parser = new XMxmlParser();
List<XLog> list = Collections.emptyList();
try (InputStream is = new FileInputStream("C:\\Users\\examplefolder\\prova1.mxml")) {
    list = parser.parse(is);
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}

System.out.println(list);