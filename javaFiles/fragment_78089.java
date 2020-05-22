String xmlDir = "C:\\Users\\Administrator\\eclipse-workspace\\XMLExamples2";
File[] files = new File(xmlDir).listFiles(new FilenameFilter() {

        @Override
        public boolean accept(File folder, String name) {
            return name.toLowerCase().endsWith(".xml");
        }
    });

for(File file : files){

    Document doc = db.parse(file);

    Element element = (Element) doc.getElementsByTagName("composite").item(0);

    // etc...

}