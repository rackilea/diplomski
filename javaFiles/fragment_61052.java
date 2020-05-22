import java.io.*;
import java.util.*;

class e1_test{

    public static void main (String[] args) throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nn = Integer.parseInt(br.readLine());
        for(int j = 0 ; j < nn; j++){
            int n = Integer.parseInt(br.readLine());char[][] a = new char[n][n];
            int ki = -1;
            int kj = -1;
            for(int i = 0 ; i < n ; i++){
                String s = br.readLine();
                for(int k = 0 ; k < n; k++){
                    a[i][k] = s.charAt(k);
                    if(a[i][k] == 'K'){
                        ki = i;
                        kj = k;
                    }
                }
            }
            System.out.println(ans(a, ki, kj));
        }
    }

    private static int ans(char[][] a, int ki, int kj) {
        int[][] x = new int[a.length][a.length];
        for(int j = a.length-1; j >= 0; j--) {
            for(int i = 0 ; i < a.length; i++) {
                if(a[i][j] == 'P') {
                    x[i][j]++;
                }
                int temp=0;
                //note the changes from else if's to only if's
                //removal of [i-2][j+1] == 'P' condition. 
                if(i-2 >= 0 && j+1 <= a.length-1) {
                    if(temp < x[i-2][j+1])
                        temp = x[i-2][j+1];
                }
                if(i-1 >= 0 && j+2 <= a.length-1) {
                    if(temp < x[i-1][j+2])
                        temp = x[i-1][j+2];
                }
                if(i+2 <= a.length-1 && j+1 <= a.length-1) {
                    if(temp < x[i+2][j+1])
                        temp = x[i+2][j+1];
                }
                if(i+1 <= a.length-1 && j+2 <= a.length-1) {
                    if(temp < x[i+1][j+2])
                        temp = x[i+1][j+2];
                }
                x[i][j] += temp;
            }
        }
        return x[ki][kj];
    }
}