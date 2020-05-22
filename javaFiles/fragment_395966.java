static int removeDuplicates(double arr[], int n) 
{ 
    // return the array itself, if it is empty or contains only one element
    if (n==0 || n==1) 
        return n; 

    //creating a temporary array to hold new array data
    double[] temp = new double[n]; 

    // Start traversing elements 
    int j = 0; 
    for (int i=0; i<n-1; i++) 

        //checking for duplicates and store elements in 
        //temp[] array if not duplicated.
        if (arr[i] != arr[i+1]) 
            temp[j++] = arr[i]; 

    // Store the last element as whether 
    // it is unique or repeated, it hasn't 
    // stored previously 
    temp[j++] = arr[n-1];    

    // Modify original array 
    for (int i=0; i<j; i++) 
        arr[i] = temp[i]; 

    return j; 
}