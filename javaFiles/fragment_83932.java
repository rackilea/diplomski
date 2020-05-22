public static <E> void printList(ArrayList<E[]> arrList) {
    for (E[] arr : arrList) {
        for (E elm : arr) {
            System.out.println(elm);
        }

    }
}