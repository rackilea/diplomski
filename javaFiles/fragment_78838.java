import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProcessDataFile {


public static void main(String[] args) throws IOException {

    String fileName = "dataset529.txt";
    String temp;
    int max = Integer.MIN_VALUE;
    int i = 0;
    int[] numbers = new int[10000];

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        while((temp = br.readLine()) != null) {
            if(temp.isEmpty())
                break;
            numbers[i++] = Integer.parseInt(temp);
        }
    }

    for(i = 0; i < numbers.length; i++)
        if(max < numbers[i])
            max = numbers[i];

    System.out.println(max);
}