@GET
@Produces("application/json")
@Path("/details/{location}")
public List<Map<String, Object>> getFolderDetails(@PathParam("location") String location) {
    File folder = new File(DIRECTORY_LOCATION + "/" + location);
    File[] listOfFiles = folder.listFiles();
    List<Map<String, Object>> folders = new ArrayList<Map<String, Object>>();
    for (File file : listOfFiles) {
        Map<String, Object> item = new LinkedHashMap<String, Object>();
        item.put("name", file.getName());
        item.put("size", file.length());
        item.put("lastModified", file.lastModified());
        // etc, adding things that have values from java.lang.* package
        folders.add(folder);
    }
    return folders;
}