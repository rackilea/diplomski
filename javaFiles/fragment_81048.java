import java.util.ArrayList;
import java.util.Random;

public class Solution  {
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
                   board[i][j] = getUniqueRandom(75, 61);
               if(i==board.length/2 && j==board.length/2) board[i][j] = 0;
               System.out.printf("%-3s", board[i][j]);
           }
           System.out.println("");     
    }
    }
    static int getUniqueRandom(int max, int min){
        int num = r.nextInt(max-min+1) + min;
        while (random.contains(num)) {
            num = r.nextInt(max-min+1) + min;
        }
        random.add(num);
        return num;
    }
}