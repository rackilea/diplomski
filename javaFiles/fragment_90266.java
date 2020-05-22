private static void quickSort (ArrayList <String> list, int first, int last) {

    int g = first; 
    int h = last;

    int midIndex = (first + last) / 2;
    String dividingValue = list.get(midIndex);