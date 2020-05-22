import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class ReadingFileWithDoubles
{
    private static final int MIN_SIZE = 256000;
    private static final int MAX_SIZE = 2048000;

    public static void main(String[] args) throws IOException
    {
        generateFiles();

        long before = 0;
        long after = 0;
        double result[] = null;

        for (int n=MIN_SIZE; n<=MAX_SIZE; n*=2)
        {
            String fileName = "doubles"+n+".txt";

            for (int i=0; i<10; i++)
            {
                before = System.nanoTime();
                result = readWithScanner(fileName, n);
                after = System.nanoTime();

                System.out.println(
                    "size = " + n + 
                    ", readWithScanner                  " + 
                        (after - before) / 1e6 + 
                    ", result " + result);

                before = System.nanoTime();
                result = readWithStreamTokenizer(fileName, n);
                after = System.nanoTime();

                System.out.println(
                    "size = " + n + 
                    ", readWithStreamTokenizer          " + 
                        (after - before) / 1e6 +
                    ", result " + result);

                before = System.nanoTime();
                result = readWithBufferAndStringTokenizer(fileName, n);
                after = System.nanoTime();

                System.out.println(
                    "size = " + n + 
                    ", readWithBufferAndStringTokenizer " + 
                        (after - before) / 1e6 + 
                    ", result " + result);

                before = System.nanoTime();
                result = readWithStream(fileName, n);
                after = System.nanoTime();

                System.out.println(
                    "size = " + n + 
                    ", readWithStream                   " + 
                        (after - before) / 1e6 + 
                    ", result " + result);
            }
        }

    }



    private static double[] readWithScanner(
        String fileName, int size) throws IOException
    {
        try (
            InputStream is = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            Scanner scanner = new Scanner(br))
        {
            // Do this to avoid surprises on systems with a different locale!
            scanner.useLocale(Locale.ENGLISH);

            int idx = 0;
            double array[] = new double[size];
            while (idx < size)
            {
                array[idx] = scanner.nextDouble();
                idx++;
            }
            return array;
        }
    }

    private static double[] readWithStreamTokenizer(
        String fileName, int size) throws IOException
    {
        try (
            InputStream is = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr))
        {
            StreamTokenizer st = new StreamTokenizer(br);            
            st.resetSyntax();
            st.wordChars('0', '9');
            st.wordChars('.', '.');
            st.wordChars('-', '-');
            st.wordChars('e', 'e');
            st.wordChars('E', 'E');
            double array[] = new double[size];
            int index = 0;
            boolean eof = false;
            do
            {
                int token = st.nextToken();
                switch (token)
                {
                    case StreamTokenizer.TT_EOF:
                        eof = true;
                        break;

                    case StreamTokenizer.TT_WORD:
                        double d = Double.parseDouble(st.sval);
                        array[index++] = d;
                        break;
                }
            } while (!eof);
            return array;
        }
    }

    // This one is reading the whole file into memory, as a String,
    // which may not be appropriate for large files
    private static double[] readWithBufferAndStringTokenizer(
        String fileName, int size) throws IOException
    {
        double array[] = new double[size];
        try (
            InputStream is = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr))
        {
            StringBuilder sb = new StringBuilder();
            char buffer[] = new char[1024];
            while (true)
            {
                int n = br.read(buffer);
                if (n == -1)
                {
                    break;
                }
                sb.append(buffer, 0, n);
            }
            int index = 0;
            StringTokenizer st = new StringTokenizer(sb.toString());
            while (st.hasMoreTokens())
            {
                array[index++] = Double.parseDouble(st.nextToken());
            }
            return array;
        }
    }

    private static double[] readWithStream(
        String fileName, int size) throws IOException
    {
        double result[] = 
            Files.lines(Paths.get(fileName))
                .flatMap(s -> Stream.of(s.split("\\s+")))
                .mapToDouble(Double::parseDouble)
                .toArray();
        return result;
    }


    private static void generateFiles() throws IOException 
    {
        for (int n=MIN_SIZE; n<=MAX_SIZE; n*=2)
        {
            String fileName = "doubles"+n+".txt";
            if (!new File(fileName).exists())
            {
                System.out.println("Creating "+fileName);
                writeDoubles(new FileOutputStream(fileName), n);
            }
            else
            {
                System.out.println("File "+fileName+" already exists");
            }
        }
    }
    private static void writeDoubles(OutputStream os, int n) throws IOException
    {
        OutputStreamWriter writer = new OutputStreamWriter(os);
        Random random = new Random(0);
        int numbersPerLine = random.nextInt(4) + 1;
        for (int i=0; i<n; i++)
        {
            writer.write(String.valueOf(random.nextDouble()));
            numbersPerLine--;
            if (numbersPerLine == 0)
            {
                writer.write("\n");
                numbersPerLine = random.nextInt(4) + 1;
            }
            else
            {
                writer.write(" ");
            }
        }
        writer.close();
    }
}