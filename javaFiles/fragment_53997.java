public static void main(String[] args) throws Exception{

    long startTime, endTime, duration;

    //Compare 20 times QuickSort vs MergeSort
    for (int i=0;i<20;i++){

        List<Integer> arreglo = randomArrayList(100000);
        List<Integer> arreglo2 = new ArrayList<>(arreglo); // Make a copy

        startTime = System.nanoTime();
        QuickSort(arreglo);                                // Sort the original
        endTime = System.nanoTime();

        duration = (endTime - startTime)/1000000;
        System.out.println("Quicksort: " + Long.toString(duration));

        startTime = System.nanoTime();
        MergeSort(arreglo2);                               // Sort the copy
        endTime = System.nanoTime();

        duration = (endTime - startTime)/1000000;
        System.out.println("MergeSort: "+Long.toString(duration));
    }
}