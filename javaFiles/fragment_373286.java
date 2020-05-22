public class ChainCodeClass {

public static void main(String[] args)
{
    int[][] array1 = {{0,1,0,0,0,0,0,0},{0,1,0,0,0,1,0,0},{0,1,1,1,0,0,1,0},
            {0,0,0,1,1,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0}**,{0,0,0,0,0,0,0,0}**};

    int[][] array2 = {{0,0,0,0,0,0,0,0},{0,1,1,1,1,0,1,0},{0,0,0,0,1,0,1,0},
            {0,0,1,1,1,0,1,0},{0,0,1,0,0,0,1,0},{0,0,1,0,0,0,1,0},{0,0,0,0,0,0,1,1},
            {0,0,0,0,0,0,0,0}};

    System.out.print("First Image");
    print(array1);
    findfirst1(array1);
    print(array1);

    System.out.print("Second Image");
    print(array2);
    outline8(array2);
}

public static void findfirst1(int[][] array) 
{
    int value = 0;
    for(int i = 0; i < array.length; i++)
    {
        for(int k = 0; k < array.length; k++)
        {
            value = array[i][k];
            if(value == 1)
            {
                System.out.print(value + "  ");
                array[i][k] = 0;
            }
            else
            {
                System.out.println(value);
            }
        }
    }

}

public static void print(int[][] array)
{
for(int i = 0; i < array.length; i++) // print function for the array using incrementors
{
    System.out.print("\n");

    for(int k = 0; k < array.length; k++)
    {
        System.out.print(array[i][k] + "    ");
    }
}
    System.out.println();
}
 }