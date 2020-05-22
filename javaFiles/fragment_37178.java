public class Array {

    public int sizeArray;
    //we will not declare the array right at this point because we don't know the file size or in general the value of sizeArray varable.
    public String mainArray [] ;

     public String halfArray[] ;

    public void arraySizeManipulate () {

    String line = ""; 

    int x = -1;

    try {
      BufferedReader r = new BufferedReader (new FileReader("File.txt"));
      while (line != null)
      {
        line = r.readLine ();
        x++;
      }
      r.close ();
    }
    catch (IOException e)
    {
      System.out.println (e);
    }
  //here x contains the  no of lines in the file 
 sizeArray = x;
//now global array get declared using the variable  size array.
 mainArray=new String[sizeArray];
    halfArray = new String [sizeArray/2];

    }
    }