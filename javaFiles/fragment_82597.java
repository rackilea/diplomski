public static void main(String args[]) {
    int[] list = {1, 2, 3, 1, 0, 0, 0, 5, 6, 1569, 1, 2, 3, 2, 1569, 3};

    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    for (Integer nextInt : list) {
        Integer count = map.get(nextInt);
        if (count == null) {
            count = 1;
        } else {
            count = count + 1;
        }
        map.put(nextInt, count);
    }

    Integer mostRepeatedNumber = null;
    Integer mostRepeatedCount = null;
    Set<Integer>keys = map.keySet();
    for (Integer key : keys) {
        Integer count = map.get(key);
        if (mostRepeatedNumber == null) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        } else if (count > mostRepeatedCount) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        } else if (count == mostRepeatedCount && key < mostRepeatedNumber) {
            mostRepeatedNumber = key;
            mostRepeatedCount = count;
        }
    }

    System.out.println("Most repeated value is: " + mostRepeatedNumber);    

}