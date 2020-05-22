try
{
     ObjectInputStream osNew = new ObjectInputStream(new FileInputStream("Floyd.ser"));
     Floyd a = (Floyd) osNew.readObject();
     a.FW()
     osNew.close();
} catch (Exception ex1){
     ex1.printStackTrace();
}