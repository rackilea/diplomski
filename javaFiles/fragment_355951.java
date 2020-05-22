static int i=0;
public static void main(String[] args) {
    String strFilePath = "./version.txt";
    try
    {
      FileInputStream fin = new FileInputStream(strFilePath);
      DataInputStream din = new DataInputStream(fin);
      i = din.readInt();
      System.out.println("int : " + i);
      din.close();
    }
    catch(FileNotFoundException fe)
    {
       System.out.println("FileNotFoundException : " + fe);
    }
    catch(IOException ioe)
    {
       System.out.println("IOException : " + ioe);
    }
}
private final int VERSION = i;