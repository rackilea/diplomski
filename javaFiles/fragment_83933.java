public static void printList(ArrayList<Object[]> arrList) {
    for (Object[] arr : arrList) {
        for (Object elm : arr) {
            System.out.println(elm);
        }
    }
}