import java.io.BufferedReader; 
import java.io.FileReader;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.IOException;
class myRead{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader("test.txt")); 
        String numberOfElements = inputFile.readLine();
        //this is the first line which contains the number "10"
        //System.out.println(numberOfElements);
        String secondLine = inputFile.readLine();
        //this is the second line which contains your data, split it using "#" as a delimiter
        String[] strArray = secondLine.split("#");
        //System.out.println(Arrays.toString(strArray));
        //System.out.println(strArray[0]);
        String thirdLine = inputFile.readLine();
        //this is the third line which contains your data, split it using "#" as a delimiter
        String[] dataArray = thirdLine.split("#");
        //combine arrays
        String[] combinedArray = new String[strArray.length];
        for (int i=0;i<strArray.length;i++) {
        combinedArray[i]=strArray[i]+"_"+dataArray[i];
        System.out.println(combinedArray[i]);
        }
}
}