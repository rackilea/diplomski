private static int addOddAndSubtractEvenPositions(List<Integer> values, int position) {

    // stop condition
    if (position >= values.size()) {
        return 0;
    }

    // recurse
    int tailResult = addOddAndSubtractEvenPositions(values, position + 1);

    // calculate
    int currentValue = values.get(position);
    if (position % 2 == 0) {
         currentValue = -currentValue;
    }       
    return currentValue + tailResult;   
}

public static void main(String[] args) {
    List<Integer> values = Arrays.asList(2, 5, 3, 7, 11, 1);    
    System.out.println(addOddAndSubtractEvenPositions(values, 0));
}