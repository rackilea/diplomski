public static int[] sirala(int[] arr)
{
        int[] yeni = new int[arr.length];
        //shifting ith largest element to (i-1)th pos of arr
        for(int i = 0; i< arr.length;i++)
        {
            for(int j = i+1; j< arr.length;j++){
                if(arr[j] > arr[i]){
                    int tmp=arr[i];
                    arr[i] = arr[j];
                    arr[j]=tmp;
                }
            }
            //assigning element to new array
            yeni[i] = arr[i];
        }
        return yeni; 
}