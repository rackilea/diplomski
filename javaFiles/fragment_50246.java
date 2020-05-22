//...
if(!f.exists()) {
   f.mkdir();
}
//...
MyWriter writer =  new MyWriter();
writer.write(console, out.getAbsolutePath());