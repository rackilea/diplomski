public static File createDirectory(String directoryPath) throws IOException {
    File dir = new File(directoryPath);
    if (dir.exists()) {
        return dir;
    }
    if (dir.mkdirs()) {
        return dir;
    }
    throw new IOException("Failed to create directory '" + dir.getAbsolutePath() + "' for an unknown reason.");
}