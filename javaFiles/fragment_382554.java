@Autowired
private ServletContext servletContext;

public static List<File> getFileList() {
    Resource resource = new ServletContextResource(servletContext, "/resources/public");
    File folder = resource.getFile();
    File[] listOfFiles = folder.listFiles();
    list.addAll(Arrays.asList(listOfFiles));

    return list;
}