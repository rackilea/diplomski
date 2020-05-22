import java.io.*;
import java.util.*;
class help
{
    public static void main(String args[])
    {
        ArrayList<String> list = new ArrayList<String>();
        File file1 = new File("E://Javaprograms//xyz.txt");    //Try-With-Resources so we autoclose the reader after try block
        try
        { 
            Scanner sc  = null;    
            sc = new Scanner( file1);        
            String  line = "";
            int maxLen = 0;
            while(sc.hasNextLine()){//While there are more lines
                line = sc.nextLine();
                list.add(line);//add this line to list of string. Read about ArrayList.
                if(line.length() > maxLen)
                    maxLen = line.length(); //finding maximum length of line
            }
            int rows = maxLen;
            int col = list.size();
            double arr[][] = new double[rows][col];
            rows = 0; // rows initialized to zero. Go through code to know why?
            for(int i=0;i<col;i++)
            {
                String s = list.get(i); // getting line from list
                String values[] = s.split(","); // splitting them to hold double. Remember they are still String
                if(rows < values.length)
                    rows = values.length; // using this to determine the maximum length of a column or number of rows that will actually hold values. Other rows will simply contain not required values
                for(int j=0;j<values.length;j++)
                {
                    arr[j][i] = Double.parseDouble(values[j]);// converting string to double and storing them at their position
                }
            }
            for(int i=0;i<rows;i++)
            {
                for(int j=0;j<col;j++)
                {
                    System.out.print(arr[i][j]+", ");// displaying numbers
                }
                System.out.println();
            }

        } catch (Exception io) {
            io.printStackTrace();
        }    
    }
}