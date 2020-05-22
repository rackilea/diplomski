static void removeEvenInRange(List<Integer> list, int i, int j){

    List<Integer> subList= list.subList(i, j);
    Iterator<Integer> itr = subList.iterator();


    while (itr.hasNext()){
        int element = itr.next();
        if (element % 2 == 0) {
            itr.remove();
        }
    }
    System.out.println(list);
}