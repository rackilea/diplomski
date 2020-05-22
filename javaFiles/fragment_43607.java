public static void processData(int[] vals, int lookingFor, double incSize, List list) {
    double count = 0;
    for (int i : vals) {
        if (i == lookingFor) {
            System.out.println(i);
            count++;
        }
    }
    System.out.println("count: " + count);
    incSize = count * incSize;
    System.out.println("incBy: " + incSize);
    int rounded = (int) Math.round(incSize);
    System.out.println("rounded: " + rounded);
    for (int i = 0; i < rounded; i++) {
        list.add(lookingFor);
    }
    System.out.println("Result: ");
    for (Object i : list) {
        System.out.println(i);
    }
}

public static void main(String[] args) {
    List<Integer> x = new ArrayList<>();

    int[] screen_ids = {17, 17, 13, 13, 13,
        12, 11, 11, 11, 10, 10, 10, 9, 9, 9,
        9, 8, 7, 7, 7, 5, 5, 4, 4, 3, 3, 3, 2, 2, 1};

    for (int i : screen_ids) {
        x.add(i);
    }
    processData(screen_ids, 17, 1.4, x);
    System.out.println(" x length: " + x.size());
}