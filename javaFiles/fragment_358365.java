public class YourClass {
    static {
        // path to and base name of the library in the jar file
        String libResourcePath = "path/to/library/yourLib.";

        // assume Linux
        String extension = "so";

        // Check for Windows
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win"))
            extension = "dll";

        libResourcePath += extension;

        // find the library in the jar file
        InputStream is = ClassLoader.getSystemResourceAsStream( libResourcePath );

        // create a temp file for the library
        // (and we need the File object later so don't chain the calls)
        File libraryFile = File.getTempFile("libName", extension);

        // need a separate OutputStream object so we can
        // explicitly close() it - can cause problems loading
        // the library later if we don't do that
        FileOutputStream fos = new FileOutputStream(libraryFile);

        // assume Java 9
        is.transferTo(fos);

        // don't forget these - especially the OutputStream
        is.close();
        fos.close();

        libraryFile.setExecutable(true);
        libraryFile.deleteOnExit();

        // use 'load()' and not 'loadLibrary()' as the
        // file probably doesn't fit the required naming
        // scheme to use 'loadLibrary()'
        System.load(libraryFile.getCanonicalPath());
    }

    ...
}