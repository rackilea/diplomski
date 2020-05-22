public static String searchAssets(AssetManager asm, String path,
        String filename) {

    // TODO uses hard coded path separator

    // search for the file, filename, starting at path path in the assets
    // folder
    // asm must be initialized by the caller using an application context
    // returns an empty string for non existent files or for filename = ""

    if (asm == null) {
        return "";
    }

    String foundFile = ""; // return value

    try {
        // get a list of assets located at path
        String[] files = asm.list(path);

        // files may be null if an invalid path is passed
        if (files != null && files.length > 0) {

            // loop through each asset for either a subfolder to search
            // recursively or the file we are looking for
            for (String file : files) {

                foundFile = searchAssets(asm, path + "/" + file, filename); // recurse
                                                                // this
                                                                // subfolder

                // searchAssets returns either the name of our file, if
                // found, or an empty string
                if(!foundFile.equals("")){
                    return foundFile;
                }
            }
        } else {
            if (path.equals(filename)) {
                return path;
            }else{
                return "";
            }
        }

    } catch (IOException e) {
        // eat the exception - the caller did not set us up properly
    }

    return "";
}