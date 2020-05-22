import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVWriter;

/**
 * @author Girish
 * 
 */
public class CSVWritterExample
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        int[][] data = new int[100][100];

        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                data[i][j] = j * i;
            }
        }

        exportDataToExcel("D:/sample.csv", data);
    }

    public static void exportDataToExcel(String fileName, int[][] data) throws FileNotFoundException, IOException
    {
        File file = new File(fileName);
        if (!file.isFile())
            file.createNewFile();

        CSVWriter csvWriter = new CSVWriter(new FileWriter(file));

        int rowCount = data.length;

        for (int i = 0; i < rowCount; i++)
        {
            int columnCount = data[i].length;
            String[] values = new String[columnCount];
            for (int j = 0; j < columnCount; j++)
            {
                values[j] = data[i][j] + "";
            }
            csvWriter.writeNext(values);
        }

        csvWriter.flush();
        csvWriter.close();
    }
}