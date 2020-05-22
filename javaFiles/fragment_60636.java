public String importFromCsvFile(File f) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
    FileReader fr = new FileReader(f);
    BufferedReader buffReader = new BufferedReader(fr);
    String className = buffReader.readLine();

    buffReader.close(); // you can also not close it and use buffReader as your reader for the CSV

    //Java reflection to get the Class Object.
    Class beanClass = Class.forName("model." + className);

    Object beanObject = beanClass.newInstance(); // this is never needed

    Reader reader = new FileReader(f); // use buffReader instead of creating a new one

    ValueProcessorProvider provider = new ValueProcessorProvider();
    CSVEntryParser<?> entryParser = new AnnotationEntryParser<>(beanClass, provider);
    CSVReader<?> csvFileReader= new CSVReaderBuilder<>(reader).entryParser((CSVEntryParser<Object>) entryParser).build();

    Iterator<?> it = csvFileReader.iterator();

    while (it.hasNext()) {

        Object obj = it.next(); // obj is an instance of Car with your data
        boolean isCar = obj instanceof Car; // will be true
    }
}