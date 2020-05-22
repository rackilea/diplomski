public int LocationFinder()
    {   
          int Start=0,End=arr.length - 1,Item=a[4];
//Item = key 

while(Start<=End)
        {
            int mid=Start + (End-Start)/2;
            //Checking if item is present at mid     
            if(arr[mid]==Item)
            {
            return mid; //returning the index 
            }
            //if item is greater, than ignore the left side
            else if(arr[mid]<Item)
            {
                Start=mid+1;
            }
            //if item is smaller, than ignore the right side
            else
                End=mid-1;
 }
//returning -1 if the value is not found
return -1;
}