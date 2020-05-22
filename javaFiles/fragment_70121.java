static void loop(List<Integer> originalList, List<Integer> newvalues, int index) {
    if (index >= originalList.size())
        System.out.println(originalList);
    else {
        for (int i = 0; i < newvalues.size(); ++i) {
            originalList.set(index, newvalues.get(i));
            loop(originalList, newvalues, index + 1);
        }
    }
}