public void preloadModels() throws IOException {
    File directory = new File(signlink.findcachedir() + "raw");
    for (File file : directory.listFiles()) {
        if (!file.getName().endsWith(".dat")) continue;
        byte[] buffer = getBytesFromFile(file);
        Model.method460(buffer, Integer.parseInt(file.getName().replace(".dat", "")));
    }
}

public static byte[] getBytesFromFile(File file) throws IOException {
    byte[] buffer = new byte[(int) file.length()];
    try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
        dis.readFully(buffer);
        return buffer;
    }
}