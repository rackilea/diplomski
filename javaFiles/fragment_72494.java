void createMyShape(String[] myArray){
  if(myArray[0].equals("LINE")){
    Shape s = createShape(LINE);
    s.vertex(int(myArray[1]), int(myArray[2]));
    s.vertex(int(myArray[3]), int(myArray[4]));
    s.endShape();
  }
  else if ...
}