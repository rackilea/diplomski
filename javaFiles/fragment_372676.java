while(true){
    int pivot=array[lower];

    while(array[lower]<pivot)
        lower++;

    while(array[higher]>pivot)
        higher--;


    if(lower<higher){   //this will just swap the 3's with each other. 
        int temp=array[higher];
        array[higher]=array[lower];  
        array[lower]=temp;
    }
    else{
      return higher;
    }
}