static int maxSoFar = Integer.MIN_VALUE;  // set to a very small number
public static void main (String [] args) throws Exception 
{
    int [] arr = {1,3,7,5,4};

    System.out.println("The max int using a recursive search is: " + recursiveMax(arr,0));  // pass it in

}

public static int recursiveMax(int[]arr, int index) {  

    if (index > arr.length-1) {
        return maxSoFar;
    }
    else {
        if (arr[index] >= maxSoFar){
            maxSoFar = arr[index];
        }
        return recursiveMax(arr,index + 1);
    }
}