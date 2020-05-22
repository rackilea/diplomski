JFileChooser fileChooser = new JFileChooser();
fileChooser.setFileView(new FileView() {

   @Override
   public String getName(File f) {
      String name = FileSystemView.getFileSystemView().getSystemDisplayName(f);

      // If names is empty use the description
      if(name.equals("")) {
         name = FileSystemView.getFileSystemView().getSystemTypeDescription(f);
      }

      return name;
   }
});