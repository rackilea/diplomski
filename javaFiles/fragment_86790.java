import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;

class FileManager
{

  FileManager()
  {}

  public void saveMatrix(String path, DataMatrix dm)
  {
    try
    {
    FileOutputStream file = new FileOutputStream(path);
    ObjectOutputStream output = new ObjectOutputStream(file);
    output.writeObject(dm); 
    output.close();
    }
    catch (Exception e)
    {
       e.printStackTrace();
    }
  } 

  public DataMatrix openMatrix(String path)
  {
    DataMatrix dm = null;

    try
    {

       FileInputStream file = new FileInputStream(path);
       ObjectInputStream input = new ObjectInputStream(file);
       Object aux = input.readObject();
       input.close();
       if(aux instanceof DataMatrix)
       {
         dm = (DataMatrix)aux;
       }        
    }
    catch (EOFException e1)
    {
       System.out.println ("Fin de fichero");
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }

    return dm; 
  }
}