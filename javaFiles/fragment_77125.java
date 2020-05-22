public static void main(String[] args) {
    File f = findJarLocation("jaxb-impl.jar");
    System.out.println(f);
}

public static File findJarLocation(String entryName) {

    String pathSep = System.getProperty("path.separator");

    String[] pathEntries = System.getProperty("java.class.path").split(pathSep);
    for(String entry : pathEntries) {
        File f = new File(entry);
        if(f.getName().equals(entryName)) {
            return f.getParentFile();
        }
    }
    return null;
}