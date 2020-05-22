public void mouseClicked(MouseEvent ev){
 if(ev.getClickCount() ==2){
  try{
  java.awt.Desktop.getDesktop().open(new File("path/to/file"));
}catch(FileNotFoundException ex){
//.....
}
}
}