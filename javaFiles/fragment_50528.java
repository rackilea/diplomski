private static void recursionSort(ArrayList<GeometricObject> list){
    recursionSort(list, 0, list.size())
    System.out.println("Recursion sort:" + list);        
}

private static void recursionSort(ArrayList<GeometricObject> list, int low, int high){
    if (low < high){
        int minIndex = low;
        GeometricObject min = list.get(low); //set min to first object in range
        for (int i = low + 1; i <= high; i++){ //loop through all values other than first
            if (list.get(i).getArea() < min.getArea()){ //check if the value is smaller than current min
                min = list.get(i); //if it is update the min
                minIndex = i; //store min index so we can swap locations later
            }
        }

        Collections.swap(list, low, minIndex); //move the original min to new min's old index (tricky wording)
        list.set(low, min); //set the old lowest to the new lowest using store min value

        recursionSort(list, low + 1, high); //call it again

    }

}