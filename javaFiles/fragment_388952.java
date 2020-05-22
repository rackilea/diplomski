// Create a File object on the root of the directory 
// containing the class file
File file = new File("c:\\class\\");

try {
    // Convert File to a URL
    URL url = file.toURL();          // file:/c:/class/
    URL[] urls = new URL[]{url};

    // Create a new class loader with the directory
    ClassLoader loader = new URLClassLoader(urls);

    // Load in the class; Class.childclass should be located in
    // the directory file:/c:/class/user/information
    Class cls = loader.loadClass("user.informatin.Class");
} catch (MalformedURLException e) {
} catch (ClassNotFoundException e) {
}