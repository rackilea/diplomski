// returns null if file isn't relative to folder
public static String getRelativePath(File file, File folder) {
    String filePath = file.getAbsolutePath();
    String folderPath = folder.getAbsolutePath();
    if (filePath.startsWith(folderPath)) {
        return filePath.substring(folderPath.length() + 1);
    } else {
        return null;
    }
}