public int getNthLargestNum(int[] data, int n){
    TreeSet<Integer> set = new TreeSet<Integer>();
    foreach(int number : data)
    {
        set.add(number);
        if(set.size() > 5)
            set.pollFirst();
    }

    return set.first();
}