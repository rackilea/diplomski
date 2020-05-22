public static void ReverseArray(int[] intArr)
{
    for(int x = 0, z = intArr.length-1; x < intArr.length /2; x++, z --)
    {
        //intArr = {1,2,3,4,5,6,7,8,9}

        int n1 = intArr[x]; //n1 = 1 
        int n2 = intArr[z]; //n2 = 9

        intArr[x] = n2; //Swap the element at index x with n2.
        intArr[z] = n1; //Swap the element at index z with n1.

       //intArr = {9,2,3,4,5,6,7,8,1}
    }


}