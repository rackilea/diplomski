public FileChooser () {
   //call superclass constructor
   super("File Chooser");
   fileChooser=fileChooser = new JFileChooser();
   fileFilter=new FileNameExtensionFilter("text file", "txt");
   fileChooser.setFileFilter(fileFilter);

  ...
   }