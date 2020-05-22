String javaLibraryPath = System.getProperty("java.library.path");

if(!javaLibraryPath.contains(File.pathSeparator + "." + File.pathSeparator)){

    StringBuilder sb = new StringBuilder(javaLibraryPath).append(File.pathSeparator).append(".");
    // The line above appends "." (current directory) to the library path
    // Of course 'rxtxSerial.so' must be placed in the current directory

    System.setProperty("java.library.path", sb.toString());

    try {
        Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
        sysPathsField.setAccessible(true);
        sysPathsField.set(null, null);// Setting this field to null will force a reevaluation of 
                                      // the library path as soon as loadLibrary() is called

    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
        ex.printStackTrace();
    }
}