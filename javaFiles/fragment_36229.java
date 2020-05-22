public static int productOfOdds(int[] arr, int index){
    if (index == 1) 
    { 
        if ((arr[index-1]%2) != 0)  
             return arr[index-1]; 
        else 
             return 1; 

    }

    else if((arr[index-1]%2) != 0 )           
         return (arr[index-1] * productOfOdds(arr, index-1));            
    else
         return productOfOdds(arr, index-1);            
}