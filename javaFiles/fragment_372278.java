int binSearch(int arr[], int target)
{
    int low=0;
    int high= arr.length -1; //Correct condition

    while(low<=high)   //Correct condition
    {
        int mid = (low+high)/2;

        if(arr[mid] == target)
            return mid;

        if(target>arr[mid])
            low=mid+1;

        else{
            high=mid-1;
          }

    }

    return -1;
}