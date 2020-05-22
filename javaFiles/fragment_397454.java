JFileChooser chooser = new JFileChooser(".");


   FileFilter type1 = new FileNameExtensionFilter("Images", "jpg", "png", "JPG", "PNG");
   FileFilter type2 = new FileNameExtensionFilter("PDF Documents", "pdf");
   FileFilter type3 = new FileNameExtensionFilter("All Files", ".");


   chooser.addChoosableFileFilter(type1);
   chooser.addChoosableFileFilter(type2);
   chooser.addChoosableFileFilter(type3);

   chooser.setFileFilter(type1); // Initial filter setting
   chooser.setFileFilter(type2);
   chooser.setFileFilter(type3);

   chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
   chooser.setAcceptAllFileFilterUsed(false);

   int status = chooser.showOpenDialog(this);
   if (status == JFileChooser.APPROVE_OPTION) {
       File f = chooser.getSelectedFile();
       lblFileName.setText(f.toString());
       if (chooser.getFileFilter() == type1) {
           //you can add code for file type 1
       } else if (chooser.getFileFilter() == type2) {
           //you can add code for file type 2
       }
   }