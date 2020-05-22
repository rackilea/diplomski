static int findProductSum(int A[], int n) 
{ 
    // calculating array sum (a1 + a2 ... + an) 
    int array_sum = 0; 
    for (int i = 0; i < n; i++) 
        array_sum = array_sum + A[i]; 

    // calcualting square of array sum 
    // (a1 + a2 + ... + an)^2 
    int array_sum_square = array_sum * array_sum; 

    // calcualting a1^2 + a2^2 + ... + an^2 
    int individual_square_sum = 0; 
    for (int i = 0; i < n; i++) 
        individual_square_sum += A[i] * A[i]; 

    // required sum is (array_sum_square - 
    // individual_square_sum) / 2 
    return (array_sum_square - individual_square_sum) / 2; 
} 

// Driver code 
public static void main(String[] args)  
{ 
    int A[] = {1, 3, 4}; 
    int n = A.length; 
    System.out.println("sum of product of all pairs of array "
            +"elements : " + findProductSum(A, n)); 
    } 
}