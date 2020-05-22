import java.io.*;
import java.util.*;
public class FeatureSelection500 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    // TODO code application logic here

    File file1 = new File("E://implementation1/practise/ComUpdatusPS.exe.hex-04-ngrams-Freq.txt");
    File file2 = new File("E://implementation1/practise/top-300features.txt");

    Scanner scan1 = new Scanner(file1);

    Scanner scan2 = new Scanner(file2);

    List<String> txtFile1 = new ArrayList<String>();

    List<String> txtFile2 = new ArrayList<String>();

    while (scan1.hasNext()) {
        txtFile1.add(scan1.nextLine());
    }

    while (scan2.hasNext()) {
        txtFile2.add(scan2.nextLine());
    }
    for (int i = 0; i < txtFile2.size(); i++) {
        String lineI = txtFile2.get(i);
        //  System.out.println(fileContentSingleLine);
        for (int j = 0; j < txtFile1.size(); j++){ // z < txtFileOne.size(
            String lineJ = txtFile1.get(j);
            //  System.out.println(fsl+"\t \t"+ s);
            if (lineI.equals(lineJ)) {
                System.out.println(lineI + "\t \t" + lineJ);
                // my line

                // System.out.println(fsl);
            }
        }

    }
  }
}