String fileName = "/WEB-INF/resources/images/logomailtemplate.png";
InputStream stream = getServletContext().getResourceAsStream(fileName); //or null if you can't obtain a ServletContext

if (stream == null) {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    if (classLoader == null) {
        classLoader = this.getClass().getClassLoader();
    }

    stream = classLoader.getResourceAsStream(fileName);
}

DataSource ds = new ByteArrayDataSource(stream, "image/*");