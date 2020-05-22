//deserialize the Color file
try(
  InputStream file = new FileInputStream("myBgColor.ser");
  InputStream buffer = new BufferedInputStream(file);
  ObjectInput input = new ObjectInputStream (buffer);
){
  //deserialize the List
  bgColor = (Color)input.readObject();
}
catch(ClassNotFoundException ex){
  fLogger.log(Level.SEVERE, "Cannot perform input. Class not found.", ex);
}