/* package whatever; // don't place package name! */

import java.util.*;

import java.lang.*;

import java.io.*;


class Ideone
    {
    public static void main (String[] args) throws java.lang.Exception
    {
    // your code goes here
        int[] test = {5,4,3,5,7,5,1,5,96};
    System.out.print("Before: ");
    printList(test);
    mergeSort(test, 0, test.length-1);
    System.out.print("After:  ");
    printList(test);
}

public static void printList(int[] test){
for (int i= 0; i < test.length; i++){
    System.out.print(test[i] + " ");
}
System.out.println();
}

public static void merge(int[] A, int p, int q, int r){
int n1 = q - p + 1;
int n2 = r - q;

int[] L = new int[n1];
int[] R = new int[n2];

for(int i = 0; i < n1; i++){
    L[i] = A[p+i];
}
for (int j = 0; j < n2; j++){
    R[j] = A[q+j+1];
}
//int i = 0;
//int j = 0;

   /* for (int k=p; i <= r; i++){
    if (i > n1){
        A[k] = R[j];
        j++;
    }
    else if (j > n2){
        A[k] = L[i];
        i++;
    }
    else if (L[i] <= R[j]){
        A[k] = L[i];
        i++;
    }
    else{
        A[k] = R[j];
        j++;
    }
    }*/

       int i = 0, j = 0;


    int k = p;
    while (i < n1 && j < n2)
    {
        if (L[i] <= R[j])
        {
            A[k] = L[i];
            i++;
        }
        else
        {
            A[k] = R[j];
            j++;
        }
        k++;
    }


    while (i < n1)
    {
        A[k] = L[i];
        i++;
        k++;
    }


    while (j < n2)
    {
        A[k] = R[j];
        j++;
        k++;
    }

}

public static void mergeSort(int[] A, int p, int r){
if (p < r){
    int q = (p + r) / 2;
    mergeSort(A, p, q);
    mergeSort(A, q+1, r);
    merge(A, p, q, r);
}
}

}