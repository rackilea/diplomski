public Image createImage(String path) {
   Image image = getImageRegistry().get(path);
   if (image == null) {
     getImageRegistry().put(path, AbstractUIPlugin.
       imageDescriptorFromPlugin(ID, path));
     image = getImageRegistry().get(path);
   }
   return image;
 }