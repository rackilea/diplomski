import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackOverflow {

 public static void main(String[] args) throws IOException {
  
   BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

      System.out.println("Enter Full Name: ");

     
      String str = input.readLine();
      int[] array = new int[str.length()];;

              for (int i = 0; i < str.length(); i++){
                  char c = str.charAt(i);
                  int k = (int) c;
                  array[i] = k;
          }
  
   
        System.out.println("Before Selection Sort");  
        for(int i:array){  
            System.out.print(i+" ");  
        }  
        System.out.println();  
          
        selectionSort(array);//sorting array using selection sort  
         
        System.out.println("After Selection Sort");  
        for(int i:array){  
            System.out.print(i+" ");  
        }  
 }
 
 public static void selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;//searching for lowest index  
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
    }  
}