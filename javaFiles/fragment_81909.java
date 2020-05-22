public static void count(int[] numbers) {
    int[] counts = new int[numbers.length];
    int[] mapping = new int[numbers.length];
    int mappings = 0; // how many mappings are used

    // map them
    for (int number : numbers) {
        boolean found = false;
        for (int i = 0; i < mappings; i++) {
            if (number == mapping[i]) {
                found = true; // already mapped
            }
        }
        if (!found) {
            mapping[mappings++] = number; // add a new mapping
        }
    }

    // count them
    for (int number : numbers) {
        int mapped = 0;
        boolean found = false;
        for (int i = 0; i < mappings; i++) {
            if (number == mapping[i]) {
                found = true;
                mapped = i; // found the mapping
                break;
            }
        }
        if (!found) throw new IllegalStateException("can't happen");
        counts[mapped]++;
    }

    // print them
    for (int i = 0; i < mappings; i++) {
        int number = mapping[i];
        int count = counts[i];
        System.out.format("%,d occurs %d time%s%n", number, count, count==1?"":"s");
    }
}