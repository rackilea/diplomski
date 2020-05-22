public class BubbleSort {
    static double bestTime = 10000000, worstTime = 0;  //global variables
public static void main(String[] args) {
    int BubArray[] = new int[]{3,5,3,2,5,7,2,5,8};

    System.out.println("Array Before Bubble Sort");
    for(int a = 0; a < BubArray.length; a++){
    System.out.print(BubArray[a] + " ");

    }

  System.out.println("\n Entering Loop...");

  for(int i=0; i<1000;i++)
  {  
  bubbleSortTimeTaken(BubArray, i);
  }


        int itrs = bubbleSort(BubArray);
        System.out.println("");               
        System.out.println("Array After Bubble Sort");
        System.out.println("Moves Taken for Sort : " + itrs + " moves.");
        System.out.println("BestTime: " + bestTime + " WorstTime: " + worstTime);
        System.out.print("Sorted Array: \n");
            for(int a = 0; a < BubArray.length; a++){
                    System.out.print(BubArray[a] + " ");
            }
    }

 private static int bubbleSort(int[] BubArray) {

    int z = BubArray.length;
    int temp = 0;

    int itrs = 0;

    for(int a = 0; a < z; a++){
            for(int x=1; x < (z-a); x++){

                    if(BubArray[x-1] > BubArray[x]){

                            temp = BubArray[x-1];
                            BubArray[x-1] = BubArray[x];
                            BubArray[x] = temp;
                    }    

                    itrs++;
            }
    }

    return itrs;
}

public static void bubbleSortTimeTaken(int[] BubArray, int n) 
{

     long startTime = System.nanoTime();

     bubbleSort(BubArray);   

     double timeTaken = (System.nanoTime() - startTime)/1000000d;

     if(timeTaken > 0)
     {
         if(timeTaken > worstTime)
         {
             worstTime = timeTaken;
         }
         else if(timeTaken < bestTime)
         {
             bestTime = timeTaken;
         }

     }

     System.out.println("Loop number: "+n + " Time Taken: " + timeTaken);


}
}