public static void loadObject(){
try{
  FileInputStream saveFile = new FileInputStream("Roomcounter.txt");
  ObjectInputStream restore = ObjectInputStream(saveFile); //cannot find symbol
  Person roomCounter = (Person) restore.readObject();
  int aptA = (int) restore.getAptA();
  int aptB = (int) restore.getAptB();
  int aptM = (int) restore.getAptC()();
  restore.close();
  }catch(IOException | ClassNotFoundException exc){
   exc.printStackTrace();
}
}