/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.Random;
class project {
private static int max(int i, int j) {
    return i > j ? i : j;
}
public static void paste(int i,int j){
    System.out.println("("+i+","+j+")");
}
public static int collect(int[][] board) {

    int rowLen = board.length;
    int columnLen = board[0].length;
    int[][] F = new int[rowLen][columnLen];
    F[0][0] = (int) board[0][0];


    for (int column = 1; column < columnLen; column++) {
        F[0][column] = (int)(F[0][column - 1] + board[0][column]);
    }

    for (int row = 1; row < rowLen; row++) {
        F[row][0] = (int)(F[row - 1][0] + board[row][0]);
        for (int column = 1; column < columnLen; column++) {
            F[row][column] = (int)(max(F[row - 1][column],
                F[row][column - 1]) + board[row][column]);
        }  
    }   

    System.out.println("-------------------------------------------");
    System.out.println("maxpath board");
    for (int row = 0; row < 6; row++) {
        for (int column = 0; column < 6; column++) {
            System.out.print(F[row][column] + "  ");
        }
        System.out.println();

}
int curr=F[rowLen - 1][columnLen - 1];
int i=rowLen-1;
int j=columnLen-1;
paste(i+1,j+1);
while(i>0&&j>0){

    if(i>0&&F[i-1][j]==curr){
        i=i-1;
    }
    else if(j>0&&F[i][j-1]==curr){
        j=j-1;
    }
    else if(i>0&&F[i-1][j]==curr-1){    
        i=i-1;
        curr--;
        paste(i+1,j+1);
    }
    else if(j>0&&F[i][j-1]==curr-1){    
        j=j-1;
        curr--;
        paste(i+1,j+1);
    }

}
    return F[rowLen - 1][columnLen - 1];
}
public static void main(String[] args) {
    //create the grid
    final int rowWidth = 6;
    final int colHeight = 6;
    final int[] coinvalues = {
        0,
        1
    };
    Random rand = new Random();
    int[][] board = new int[rowWidth][colHeight];
    for (int[] board1: board) {
        for (int col = 0; col < board1.length; col++) {
            board1[col] = coinvalues[rand.nextInt(coinvalues.length)];
        }
    }System.out.println("coinboard");
    //display output
    for (int[] board1: board) {
        for (int j = 0; j < board1.length; j++) {
            System.out.print(board1[j] + " ");
            //System.out.println();
        }
        System.out.println();
    }
    System.out.println("Maximum Coins : " + collect(board));

}
}