String fileName = "WEB-INF/resources/images/logomailtemplate.png";
ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
if (classLoader == null) {
    classLoader = this.getClass().getClassLoader();
}

DataSource ds = new FileDataSource(new File(classLoader.getResource(fileName).toURI()));

//OR
DataSource ds = new URLDataSource(classLoader.getResource(fileName));