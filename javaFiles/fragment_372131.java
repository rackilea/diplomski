URL[] urls = new URL[jarFiles.size() + 1];
int idx = 0;
for(String jarFile : jarFiles) {
    urls[idx++] = new URL(JarInJarConstants.INTERNAL_URL_PROTOCOL_WITH_COLON + jarDirectoryName + JarInJarConstants.PATH_SEPARATOR + jarFile);
}        
urls[urls.length-1] = new URL("file:///C:/Users/TapasB/<INSERT CORRECT PATH>/com/");