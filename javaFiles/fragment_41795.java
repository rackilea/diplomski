//serialize the Color
try (
  OutputStream file = new FileOutputStream("myBgColor.ser");
  OutputStream buffer = new BufferedOutputStream(file);
  ObjectOutput output = new ObjectOutputStream(buffer);
){
  output.writeObject(bgColor);
}  
catch(IOException ex){
  log.log(Level.SEVERE, "Cannot perform output.", ex);
}