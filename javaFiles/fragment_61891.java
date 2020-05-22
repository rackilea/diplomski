// this is a lengthy work around to figure out the path of the jar file that   
// this application was started from
File pathToJar = new File(Util.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());

JarFile jarFile = new JarFile(pathToJar);
java.util.Enumeration enumEntries = jarFile.entries();
while (enumEntries.hasMoreElements()) {
    java.util.jar.JarEntry file = (java.util.jar.JarEntry) enumEntries.nextElement();

    if(!file.getName().contains("images/")) {
        continue;
    }

    // do something with that JarEntry

}