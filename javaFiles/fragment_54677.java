int arr[N][M] = //;
int array[N*M] = //;
int total_array_2D_size = N * M;
int j = 0;
Set<Map.Entry<Integer, Integer>> set = ratio.entrySet();  

for (Map.Entry<Integer, Integer> entry : set)
{
    int k = entry.getKey();        // Take the number
    int ratio = entry.getValue();  // Take the ratio
    int N = (total_array_2D_size * ratio) / 100; // The number of times 'k' should
                                                 // appear on the finally 2D array

    for(int i = 0; i < N; i++,j++) array[j] = k; // Fill the 1D array
}