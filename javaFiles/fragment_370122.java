public static void main(final String... args) {

    final List<String> objList = Arrays.asList("1", "2", "3", "4", "5", "6", "7");


    final List<String> reversed = objList.stream()
        .collect(LinkedList::new, LinkedList::addFirst, LinkedList::addAll);

    //[7, 6, 5, 4, 3, 2, 1]  
    System.out.println(reversed);

}