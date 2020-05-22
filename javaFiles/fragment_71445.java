public static void main(String[] argv) {
    Path myFilePath = Paths.get("c:/dump2/mytextfile.txt");

    Path zipFilePath = Paths.get("c:/dump2/myarchive.zip");
    try( FileSystem fs = FileSystems.newFileSystem(zipFilePath, null) ){
        Path fileInsideZipPath = fs.getPath("/mytextfile.txt");
        Files.copy(myFilePath, fileInsideZipPath);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}