BindingAwareModelMap bindingAwareModelMap = (BindingAwareModelMap) model;
   FileOutputStream fos = new FileOutputStream("/path/to/file");
   ObjectOutputStream out = new ObjectOutputStream(fos);
   out.writeObject(bindingAwareModelMap);
   out.close();
   fos.close();