import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
/* A Naive recursive implementation of 0-1 Knapsack problem */
class Knapsack
{

    // A utility function that returns maximum of two integers

     static int max(int a, int b) {

        return (a > b)? a : b; }

     // Returns the maximum value that can be put in a knapsack of capacity W
     static int knapSack(float W, float wt[], int val[], int n,int visited[])
     {
        // Base Case

    if (n == 0 || W == 0)
        return 0;

    // If weight of the nth item is more than Knapsack capacity W, then
    // this item cannot be included in the optimal solution
    if (wt[n-1] > W)
      {

        return knapSack(W, wt, val, n-1,visited);
      }
    // Return the maximum of two cases: 
    // (1) nth item included 
    // (2) not included
    else {

        int v1[]=new int[visited.length];
        System.arraycopy(visited, 0, v1, 0, v1.length);
        int v2[]=new int[visited.length];
        System.arraycopy(visited, 0, v2, 0, v2.length);
        v1[n-1]=1;

        int ans1 = val[n-1] + knapSack(W-wt[n-1], wt, val, n-1,v1);
        int ans2 = knapSack(W, wt, val, n-1,v2);
        if(ans1>ans2){
            System.arraycopy(v1, 0, visited, 0, v1.length);
            return ans1;
        }
        else{
            System.arraycopy(v2, 0, visited, 0, v2.length);
            return ans2;
        }
    }            
      }


   // Driver program to test above function
   public static void main(String args[])
   {
        int val[] = new int[]{29,74,16,55,52,75,74,35,78};
        float wt[] = new float[]{85.31f,14.55f,3.98f,26.24f,63.69f,76.25f,60.02f,93.18f,89.95f};
    float  W = 75f;
    int n = val.length;
    int visited[] = new int[n];
    System.out.println(knapSack(W, wt, val, n, visited));
    for(int i=0;i<n;i++)
        if(visited[i]==1)
            System.out.println(i+1);
    }
}