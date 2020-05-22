public static String findMin(String[] numbers, int counter) {
    int count = 0;
    String elements = "";
    for (String tempElement : numbers) {
        int tempCount = 0;
        for (int n = 0; n < numbers.length; n++) {
            if (numbers[n].equals(tempElement)) {
                tempCount++;
                if (tempCount > counter) {
                    count = 0;
                    break;
                }
                if (tempCount > count) {
                    elements = tempElement;
                    //  System.out.println(elements);
                    count = tempCount;
                }
            }
        }
        if(count == counter) {
            return elements;
        }
    }
    if(count < counter) {
        return "";
    }
    return elements;
}