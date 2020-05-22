public void listJarFilesAndClassVersions() {    
    Class classToCheck = javax.servlet.ServletRequestWrapper.class;
    URL location = classToCheck.getResource('/'
        + classToCheck.getName().replace('.', '/') + ".class");

    System.out.println(location.toString());

    for(Package p : Package.getPackages()) {
        if (p.getName().startsWith("javax.servlet")) {
            System.out.println("Class: " + p.getName()
                + ", version: " + p.getSpecificationVersion());
        }
    }
}