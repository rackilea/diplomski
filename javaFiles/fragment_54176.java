public LinkedList<Integer> toList(int[] arr){
    LinkedList<Integer> l = new LinkedList<Integer>();
    for(int i : arr)
        l.add(i);
    return l;
}