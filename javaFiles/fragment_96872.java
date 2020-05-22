import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadFile {

    public static void main(String[] args) {

        String fileFullPath = "C:\\Temp\\data.txt";

        /** verify that file exists */
        File checkFile = new File(fileFullPath);
        if (!checkFile.exists()) {
            System.err.println("error - file does not exist");
            System.exit(0);
        }        

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileFullPath));
            String line;

            /** keep reading lines while we still have some */
            String month;
            int number;
            boolean[] barr;

            while ((line = br.readLine()) != null) {
                month = line;

                line = br.readLine();
                number = Integer.parseInt(line);

                line = br.readLine();
                String[] arr = line.split("\\s");
                barr = new boolean[3];
                for (int i=0; i < arr.length; i++) {
                    barr[i] = Boolean.parseBoolean(arr[i]);
                }

                /** store the fields in your object, then add to array **/
                System.out.println(month);
                System.out.println(number);
                System.out.println(Arrays.toString(barr));
                System.out.println();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    } //end main()

} //end