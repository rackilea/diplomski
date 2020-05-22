import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example
{
    public static void main(String args[])
    {
        Scanner inputStream = null;
        try
        {
            String fileName = "dataset.csv";
            File file = new File(fileName);

            // we don't know the amount of data ahead of time so we use lists
            List<Double> col1 = new ArrayList<>();
            List<Double> col2 = new ArrayList<>();

            inputStream = new Scanner(file);
            while (inputStream.hasNext())
            {
                String data = inputStream.next();
                String [] arr = data.split(",");

                col1.add(Double.parseDouble(arr[0]));
                col2.add(Double.parseDouble(arr[1]));
            }

            // Covert the lists to double arrays
            double[] column1 = new double[col1.size()];
            double[] column2 = new double[col2.size()];

            for (int i = 0; i < col1.size(); i++)
            {
                column1[i] = col1.get(i);
            }

            for (int i = 0; i < col2.size(); i++)
            {
                column2[i] = col2.get(i);
            }

            // print out just for verification
            System.out.println(Arrays.toString(column1));
            System.out.println(Arrays.toString(column2));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
        }
    }
}