import java.io.*;
import javax.swing.*;
public class ReadFileInvert2{
public static void main(String args[]){
    try{
        String fileName = JOptionPane.showInputDialog("Enter File Name") + ".csv";
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        System.out.println(s);
        s = s.replaceAll("\\s","");
        s = s.replaceAll("\\|",",");
        System.out.println(s);  
        char charArray[] = s.toCharArray(); 
        int x = charArray.length - 1;
        charArray[x] = ',';

        int no = 1;
        int size = 1;
        int qty = 2;
        String sizeS = "";
        String qtyS = "";
        //String resSet[][] = new String[4][2];
        String resSize[] = new String[20];
        String resQty[] = new String[20];
        int slashNo = 0;
        String value = "";


        for (int j = 1; j < charArray.length; j++){
            int n = j;
            if (charArray[j] == ','){
                j++;
            }
            while (charArray[j] != ','){
                if (charArray[j] == '/') {
                    slashNo = j;
                    //j++;
                }
                value = value + charArray[j];
                //System.out.println(value);
                j++;
            }   
            for (int k = n;k < slashNo; k++ ) {
                sizeS = sizeS + charArray[k];
                //System.out.println(sizeS);
            }
            for (int l = slashNo + 1; l < j; l++ ) {
                qtyS = qtyS + charArray[l];
                //System.out.println(qtyS);
            }
            resSize[no] = sizeS;
            System.out.println(resSize[no]);
            resQty[no] = qtyS;
            System.out.println(resQty[no]);

            System.out.println("Size is: " + resSize[no] + ", and Qty is: " + resQty[no]);

            no++;
            slashNo = 0;
            sizeS = "";
            qtyS = "";
        }
        String fileOutput = JOptionPane.showInputDialog("Enter Output File Name: ") + ".txt";
        try{
            FileWriter fw =  new FileWriter(fileOutput);
            PrintWriter pw = new PrintWriter(fw);
            String outputSize = null;
            String outputQty = null;

            for (int t = 1; t < no; t++) {
                outputSize = resSize[t];
                outputQty = resQty[t];
                pw.println(outputSize + " = " + outputQty);
                System.out.println("Writing: "+ outputSize + " = " + outputQty);
            }
            pw.flush();
            pw.close();
            fw.close();
            fr.close();
            br.close();
        }catch(Exception ex){
            System.out.println("Output " + ex);
        }
    }catch(Exception ex){
        System.out.println(ex);
    }   
}
}