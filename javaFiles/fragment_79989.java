public static Set<List<Integer>> setNumberList(int[] numberList) {

    ArrayList<Integer> numberA = new ArrayList<Integer>();
    ArrayList<Integer> numberB = new ArrayList<Integer>();

    for (int i = 0; i < numberList.length; i++) {

        int first = numberList[i];

        for (int j = i + 1; j < numberList.length; j++) {

            int second = numberList[j];

            if ((first + second) == 5) {

                numberA.add(first);
                numberB.add(second);
            }
        }
    }
    Set<List<Integer>> result = new HashSet<List<Integer>>();
    for (int i=0; i<numberA.size(); i++) {
        int n1 = numberA.get(i);
        int n2 = numberB.get(i);
        List<Integer> numbersToAdd = Arrays.asList(n1, n2);
        result.add(numbersToAdd);
    }
    return result;
}