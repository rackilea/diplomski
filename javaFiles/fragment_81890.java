for (int j = 0 ; j < arr[i].length; j++) 
{
    if (j != arr[i].length-1) {
        arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]); 
    } else {
        arr[i][j] += arr[i+1][j];
    }
}