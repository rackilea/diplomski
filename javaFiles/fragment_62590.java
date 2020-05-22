private static void copyFile(String internal, File external) {
    InputStream stream = FileManager.class.getResourceAsStream(internal);
    if(stream == null) {
        System.err.println("Error: File not found when trying to copy at location " + internal);
    } else {
        OutputStream resStreamOut = null;
        int readBytes;
        byte[] buffer = new byte[4096];
        try {
            resStreamOut = new FileOutputStream(external);
            while((readBytes = stream.read(buffer)) > 0) {
                resStreamOut.write(buffer, 0 , readBytes);
            }
        } catch(IOException e1) {
            e1.printStackTrace();
            System.exit(1);
        } finally {
            try {
                stream.close();
                resStreamOut.close();
            } catch(IOException e2) {
                e2.printStackTrace();
                System.exit(1);
            }
        }
    }
}