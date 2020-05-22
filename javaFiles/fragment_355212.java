public static void main(String[] args) {
    printDeciBin(1);
    printDeciBin(4);
    printDeciBin(10);
    printDeciBin(11);
    printDeciBin(19);
    printDeciBin(21);
    printDeciBin(99);
    printDeciBin(100);
}

public static void printDeciBin(int number) {
    System.out.println(String.format("%d -> %s", number, findDeciBins(number).stream()
            .map(Object::toString)
            .collect(Collectors.joining(" "))));
}

static Collection<Integer> findDeciBins(int number) {
    List<Integer> l = new ArrayList<>();
    while (number != 0) {
        l.add(number % 10);
        number /= 10;
    }
    Collections.reverse(l);


    List<Integer> result = new ArrayList<>();
    while (true) {
        boolean stop = true;
        int curr = 0;
        for (int i = 0; i < l.size(); i++) {
            curr *= 10;
            if (l.get(i) != 0) {
                curr++;
                l.set(i, l.get(i) - 1);
                stop = false;
            }
        }
        if (stop){
            break;
        }
        result.add(curr);
    }

    return result;
}