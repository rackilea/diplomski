java.io.File file = new java.io.File("C:/Users/someUser/Desktop/Excercise12_15.txt");
    final int SIZE = 100;
    int [] emptyArray = new int[SIZE];

    if ( file.exists())
    {
        System.out.print("File exists");
        System.exit(0);
    }//end if 

//Place your output variable up here, so that it could be seen in the catch and finally block.

    java.io.PrintWriter output = null;
    try 
    {
        output = new java.io.PrintWriter(file);

        for (int i = 1; i < SIZE; i++)
        {
            emptyArray[i] = (int)(Math.random() * 100);
            //Your issuse was here, you didn't write the array to the file correctly
            output.print(emptyArray[i] + " "); 
        }//end for 

    }//end try 
    catch (Exception ex)
    {
        System.out.println(ex.getMessage());
    }//end catch
    finally{
        //Don't place the close in the catch block, do it in the finally, because it always
        //executes even when a catch happens.
         output.close();
    }

}