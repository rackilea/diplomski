public static void main(String[] args) {
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    int result = jfc.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = jfc.getSelectedFile();
        System.out.println("Chosen file: " +
                selectedFile.getAbsolutePath() +
                " will be deleted!");

        Path pathToBeDeleted = Paths.get(selectedFile.getAbsolutePath());

        try {
            Files.delete(pathToBeDeleted);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}