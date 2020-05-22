public static void bubbleSortTimeTaken(int[] BubArray, int n) 
{
long startTime = System.nanoTime();
    bubbleSort(BubArray);   
    double timeTaken = (System.nanoTime() - startTime);
    if (timeTaken > worstTime)
    {
        worstTime = timeTaken;
    }
    if (timeTaken < bestTime)
    {
        bestTime = timeTaken;
    }

    System.out.println(n + "," + timeTaken);

}
}