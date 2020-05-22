public static void main(String args[]) {

    ArrayList<Integer> oh = new ArrayList<Integer>();
    Random random = new Random();

    for (int i = 0; i < 100; i++) {
        oh.add(random.nextInt());
    }
    int[] elementlist = new int[oh.size()];
    Iterator<Integer> iter = oh.iterator();
    for (int j = 0; iter.hasNext(); j++) {
        elementlist[j] = iter.next();
    }

    int[] list = insertionSort(elementlist);
    for (Integer in : list) {
        System.out.println(in);
    }
}

public static int[] insertionSort(int[] list) {
    for (int i = 1; i < list.length; i++) {
        int next = list[i];
        // find the insertion location while moving all larger element up
        int j = i;
        while (j > 0 && list[j - 1] > next) {
            list[j] = list[j - 1];
            j--;
        }
        // insert the element
        list[j] = next;
    }
    return list;
}