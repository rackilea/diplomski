import java.util.Scanner;
public class Project_9_3 {


 public static void main(String[] args) {

    Scanner reader = new Scanner(System.in);

    int[] bb = {3,5,4,4,5,4,5,4,3,6,6,6,6,6};  //<<== added input

    int x = modeMethod(bb);
    System.out.print(x);
 }

 public static int search(int[] x, int y){
    int z = 0;
    for(int i = 0; i<x.length;i++){
        if(x[i] == y){                              //<<== simplified search
            return i;
        }

    }
    return -1;
 }

 public static int modeMethod(int[] x){
    int[] y = new int[9]; // first array is values
    int[] d = new int[9]; // frequency array
    int logSize = 0;
    for(int i = 0; i < x.length; i++){
        int z = search(y,x[i]);
        if(z == -1){
            int b = x[i];
            y[logSize] = b;
            d[logSize] = 1;  //<<== replaced ++ with set to 1
            logSize++;
        }
        else{
            d[z]++;    //<<== used the index returned by search
        }

    }
    int max = 0;  
    for(int i =1; i<d.length; i++){
        if(d[i] > d[max]){
            max = i;          //<<== changed how max is set
        }
    }
    return y[max];  //<<== return value associated with max
  }
 }