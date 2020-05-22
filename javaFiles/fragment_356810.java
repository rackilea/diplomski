File file = new File("D:/Data/files/store/file.txt");
file.getParentFile().mkdirs();
try {
    file.createNewFile();
} catch (IOException e) {
    e.printStackTrace();
}