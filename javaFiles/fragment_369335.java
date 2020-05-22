public class ThreeDimensionalArray
{

public static void main(String[] args)
{
int[][][] array = new int[4][5][6];//initializing array
int sum=0;//define sum
for(int[][] i: array)//start of enhanced for loop
{
for(int[] j: i)

for(int k:j) 
sum +=[k];



}//end enhanced for loop
  System.out.println("Output is",sum);//output sum
}//end method main

//end ThreeDimensionalArray
}