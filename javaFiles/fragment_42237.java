public void move(File file, File targetFile) {
    if(file.isDirectory() && file.listFiles() != null) {
        for(File file2 : file.listFiles()) {
            move(file2, new File(targetFile.getPath() + "\\" + file.getName());
        }
    }
    try {
         Files.copy(file, targetFile.getPath() + "\\" + file.getName(),  StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        e.printStackTrace();
    } 
}