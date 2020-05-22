URL url = this.getClass().getClassLoader().getResource("thepackage/ofyourclass/JunkTest.class");  //get url of class file.  expected: ("jar:file:/somepath/dist/yourjar.jar!qualified/class/name.class")
File distDir = null;
if(url.getProtocol() == "jar") {
    String classPath = null;
    String jarPath = url.getPath();
    if(jarPath.matches(".*:.*")) jarPath = new URL(jarPath).getPath();
    classPath = jarPath.split("!")[0];
    distDir = new File(classPath).getParentFile(); //may need to replace / with \ on windows?
} else { //"file" or none
    distDir = new File(url.toURI()).getParentFile();
}    
//... do what you need to do with distDir to tack on your subdirectory and file name