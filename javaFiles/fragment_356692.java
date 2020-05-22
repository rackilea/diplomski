public static void workAroundbrokenToolsAndAPIs(File sourceFile, File destFile) throws IOException {
    if(!destFile.exists()) {
        destFile.createNewFile();
    }

    FileChannel source = null;
    FileChannel destination = null;

    try {
        source = new FileInputStream(sourceFile).getChannel();
        source.position(3);
        destination = new FileOutputStream(destFile).getChannel();
        destination.transferFrom( source, 0, source.size() - 3 );
    }
    finally {
        if(source != null) {
            source.close();
        }
        if(destination != null) {
            destination.close();
        }
    }
}