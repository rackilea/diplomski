URL resource;
String[] classpaths = null;
try {
    resource = getClass().getClassLoader().getResource("META-INF/MANIFEST.MF");
    Manifest manifest = new Manifest(resource.openStream());
    classpaths = manifest.getMainAttributes().getValue("Class-Path").split(" ");
    log.info(classpaths);
} catch (IOException e) {
    log.warn("Couldn't find file: " + e);
}