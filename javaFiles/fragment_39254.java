Merge(int array1[],int array2[])
{
    int array3[]=new int[array1.length+array2.length];

    int point1=0;  //indicating current element of array1
    int point2=0;  //indicating current element of array2
    int point3=0;  //indicating current element of resultant array3

    while(point1<array1.length && point2<array2.length)
    {
        if(array1[point1]>array2[point2]) //This is to be counted as a comparison
        {
            array3[point3]=array2[point2]; //Take element of array2
            point2++;   //move to the next element of array2
            point3++;   //move to the next element of array3
        }
        else
        {
            array3[point3]=array1[point1]; //Take element of array3
            point1++;  //move to the next element of array1
            point3++;  //move to the next element of array2
        }
    }

    while(point1<array1.length)
    {
        array3[point3]=array1[point1]; //Take element of array3
        point1++;  //move to the next element of array1
        point3++;  //move to the next element of array2
    }

    while(point2<array2.legnth) 
    {
        array3[point3]=array2[point2]; //Take element of array2
        point2++;   //move to the next element of array2
        point3++;   //move to the next element of array3    
    }
}