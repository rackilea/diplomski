public static void main(String[] args)
{
    int[] array = new int[]{0,5,1,-3,2,0,4};
    int[] newArray = new int[7];
    int x = 0;
    for(int i = 0; i < array.length; i++)
    {
        x += array[i];      
        newArray[i] = x;
    }
}