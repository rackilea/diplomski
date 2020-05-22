// import HDFql package (make sure it can be found by the Java compiler/JVM)
import as.hdfql.*;

public class Example
{
    public static void main(String args[])
    {
        int data[][][] = new int[264][264][1024];
        int x;
        int y;
        int z;

        // use (i.e. open) an HDF5 file named "my_file.h5"
        HDFql.execute("USE FILE my_file.h5");

        // register variable "data" for subsequent use (by HDFql)
        HDFql.variableRegister(data);

        // select (i.e. read) a dataset name "my_dataset" and store it in variable "data"
        HDFql.execute("SELECT FROM my_dataset INTO MEMORY " + HDFql.variableGetNumber(data));

        // display content of variable "data"
        for(x = 0; x < 264; x++)
        {
            for(y = 0; y < 264; y++)
            {
                for(z = 0; z < 1024; z++)
                {
                    System.out.println(data[x][y][z]);
                }
            }
        }

        // unregister variable "data" as it is no longer used/needed (by HDFql)
        HDFql.variableUnregister(data);
    }
}