import java.io.*;
import java.util.StringTokenizer;

public class file {
public static void main(String args[]) throws IOException {

String s = "231 324 123 \n 345 565 234 \n 657 234 654";

StringTokenizer n = new StringTokenizer(s);
String [] arr = new String[9];
int nn = 0;
 while(n.hasMoreElements()){
    arr[nn] =  n.nextToken();
    nn+=1;
}

for(int iii = (arr.length -1); iii >=0 ; iii--){
   System.out.print(arr[iii] + "  ");

    if((iii % 3) == 0) {
        System.out.println();
    }
}

}



}