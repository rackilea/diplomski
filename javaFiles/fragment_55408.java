public static <E> void permute2(List<E> beginningList, List<E> endingList) {
    if (endingList.size() <= 1) {
        //combine the two lists
        List<E> result = new ArrayList<E>(beginningList);
        result.addAll(endingList);
        System.out.println(result);
    } else
        for (int i = 0; i < endingList.size(); i++) {

            //create a list without the ith element
            List<E> newList = new ArrayList<E>(endingList);
            newList.remove(i);

            //create a list by adding the ith element to beginning
            List<E> newBeginning = new ArrayList<E>(beginningList);
            newBeginning.add(endingList.get(i));

            permute2(newBeginning, newList);
        }
}