# include <stdio.h>
void find3Numbers(int A[], int arr_size, int sum)
{
    int l, r;
    for (int i = 0; i < arr_size-2; i++){
       for (int j = i+1; j < arr_size-1; j++){         
           for (int k = j+1; k < arr_size; k++){
               if (A[i] + A[j] + A[k] <= sum)
                 printf("Triplet is %d, %d, %d\n", A[i], A[j], A[k]);
            }
        }
     }
}
int main()
{
    int A[] = {1, 2, 3, 4, 6};
    int sum = 8;
    int arr_size = sizeof(A)/sizeof(A[0]);
    find3Numbers(A, arr_size, sum);
    return 0;
}