public static void serializeDataOut(IHandler ish)throws IOException{
    String fileName= "Test.txt";
    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(ish);
    oos.close();
}

public static IHandler serializeDataIn(){
   String fileName= "Test.txt";
   FileInputStream fin = new FileInputStream(fileName);
   ObjectInputStream ois = new ObjectInputStream(fin);
   IHandler iHandler= (IHandler) ois.readObject();
   ois.close();
   return iHandler;
}