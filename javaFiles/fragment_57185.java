public static void main(String[] args){
    Collection<Integer> L = new ArrayList<>();
    Collection<Integer> P = new ArrayList<>();
    P.add(0);
    P.add(1);
    P.add(3);
    P.add(4);


    L.add(1);
    L.add(3);
    L.add(5);
    L.add(6);

    printLots(L,P);

}

public static void printLots(Collection<Integer> L, Collection<Integer> P) {
    Integer[] arr = L.toArray(new Integer[L.size()]);

    Iterator<Integer> iter = P.iterator();
    int pos = 0;
    while (iter.hasNext()) {
        pos = iter.next();

        if (pos >= arr.length) {
            System.out.println("Position[P] : " + pos + "    " + "Location[L] : OUT OF INDEX.");
        } else {
            System.out.println("Position[P] : " + pos + "    " + "Location[L] : " + arr[pos]);                
        }
    }
}