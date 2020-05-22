import java.io.*;
import java.lang.*;
import java.util.*;

public class readnew
 {
        public static void main(String[] args) throws Exception 
        {
        System.out.println("Enter file name");
        DataInputStream dis=new DataInputStream(System.in);
        String dir1=dis.readLine();
        File infile = new File(dir1);
        System.out.println("Enter output file name");
        DataInputStream dis2=new DataInputStream(System.in);
        String dir3=dis.readLine();
        String path="E:/photos";
        String newpath=path + "/" +dir3;
        File outfile = new File(newpath);
        int newcount=0,newcount1=0;
        FileReader fr=new FileReader(infile);
        BufferedReader fr11= new BufferedReader(fr);
        FileWriter fw = new FileWriter(outfile);
        BufferedWriter bufferFileWriter  = new BufferedWriter(fw);
        Scanner input = new Scanner(infile);
        String[] outputArray1 = new String[31];
        String[] outputArray2 = new String[31];
        int i = 0;
               while (input.hasNextLine()) 
                {
                        String line = input.nextLine();
                        if(line.length() > 0)
                {
                        String[] columns = line.split(" ");
                        System.out.println("my first column : "+ columns[0] );
                        System.out.println("my second column : "+ columns[1] );
                        outputArray1[i] = columns[0];
                        outputArray2[i] = columns[1];
                        i++;
                }
                }
                String[][] temp = new String[2][];
                String[][] temp1 = new String[i][2];
                temp[0]= outputArray1;
                temp[1]= outputArray2;
               for (int k=0;k<2;k++)
        for (int j=0;j<i;j++)
        {
System.out.println("new row"+k+"new col"+j+"value="+temp[k][j]);
        }
        if (temp.length > 0) {
            for (int m = 0; m< temp[0].length; m++) {
                for (int n = 0; n< temp.length; n++) {
                temp1[m][n]=temp[n][m];
                    System.out.print(temp[n][m] + " ");
                }
                System.out.print("\n");
            }
        }
        System.out.println("transpose");
        for (int a=0;a<i;a++)
        for (int b=0;b<2;b++)
        {
        System.out.println("new row"+a+"new col"+b+"value="+temp1[a][b]);
        }
        System.out.println("sort");
    final Comparator<String[]> arrayComparator = new Comparator<String[]>() 
    {
        @Override
        public int compare(String[] o1, String[] o2)
        {
            return o1[1].compareTo(o2[1]);
        }
    };
    final Comparator<String[]> arrayComparator1 = new Comparator<String[]>() 
    {
        @Override
        public int compare(String[] o1, String[] o2) 
        {
            return o1[0].compareTo(o2[0]);
        }
    };
     Arrays.sort(temp1, arrayComparator);
     Arrays.sort(temp1, arrayComparator1);
     for(int p=0; p<i; p++)
        {
            for(int q=0; q<2; q++) 
            {
                System.out.print(temp1[p][q]+" ");
            }
            System.out.print("\n");
        }

                       fr.close();
                       fw.close();
                    bufferFileWriter.close();
}
}