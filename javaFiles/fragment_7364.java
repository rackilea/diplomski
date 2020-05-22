static boolean canWrite(String folderPath) {
    File file = new File(folderPath);
    String new_file = "HastaLaVistaBaby";
    if (file.isDirectory()) {
        try {
            new File(file + "\\" + new_file).createNewFile();
        } catch (IOException e) {
            return false;
        }
        new File(file + "\\" + new_file).delete();
        return true;
    } else {
        return false;

    }
}