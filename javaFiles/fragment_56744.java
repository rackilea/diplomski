import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Solution {
static ArrayList<Integer> random=new ArrayList<Integer>();
private static Random r = new Random();
public static void main(String[] args) {
    System.out.println("B  I  N  G  O");
    int[][] board = new int[5][5];        
    for(int i = 0; i < board.length; i++){
       for(int j =0; j <board.length; j++){
           if(j==0)
               board[i][j] = getUniqueRandom(15, 1);
           else if(j==1)
               board[i][j] = getUniqueRandom(30, 16);
           else if(j==2)
               board[i][j] = getUniqueRandom(45, 31);
           else if(j==3)
               board[i][j] = getUniqueRandom(60, 46);
           else if(j==4)
               board[i][j] = getUniqueRandom (75, 61);               
         if(i==board.length/2 && j==board.length/2) board[i][j] = 0;
           System.out.printf("%-3s", board[i][j]);
       }
       System.out.println("");     
    }  
    boolean[][] myBingo = new boolean[5][5];
    while(true) {
        int calledNumsInput = calledNumsInput();
        for(int i = 0; i < board.length; i++){
            for(int j =0; j <board.length; j++){
                if(calledNumsInput == board[i][j]) {
                    System.out.println("B " + board[i][j] + " is on the Board!");   
                    myBingo[i][j] = true;
                }
            }
        }
        if(isBingo(myBingo)) {
            System.out.println("BINGO");break;
        }
    }
}
static boolean isBingo(boolean[][] myBingo) {
    int hcount = 0, vcount = 0, dcount = 0; 
    for(int i = 0; i < myBingo.length; i++){
        for(int j =0; j <myBingo.length; j++){
            if(myBingo[i][j] == true)
                hcount++; 
        }
        if(hcount == 5) return true;
        else hcount = 0; 
    }
    for(int i = 0; i < myBingo.length; i++){
        for(int j =0; j <myBingo.length; j++){
            if(myBingo[j][i] == true)
                vcount++; 
        }
        if(vcount == 5) return true;
        else vcount = 0; 
    }
    for(int i = 0; i < myBingo.length; i++){
        for(int j =0; j <myBingo.length; j++){
            if((i == j) && (myBingo[i][j] == true))
                dcount++; 
        }
        if((i == myBingo.length-1) && dcount == 5) return true;
        else if((i == myBingo.length-1)) dcount = 0; 
    }
    for(int i =0; i < myBingo.length; i++){
        for(int j =0; j < myBingo.length; j++){
            if((i+j == myBingo.length-1) && (myBingo[i][j] == true)) 
                dcount++;               
            }
        if((i == myBingo.length-1) && dcount == 5) return true;
        else if((i == myBingo.length-1)) dcount = 0; 
    }
    return false;
}
static int getUniqueRandom(int max, int min){
    int num = r.nextInt(max-min+1) + min;
    while (random.contains(num)) {
        num = r.nextInt(max-min+1) + min;
    }
    random.add(num);
    return num;
 }
 static int calledNumsInput(){        
        Scanner input = new Scanner(System.in);

    System.out.print("Enter Called Number: ");
    int calledNum = input.nextInt();    

    return calledNum;
  }
}