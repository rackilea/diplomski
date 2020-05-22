public static void main(String[] arguments) {
    int limit = 15;
    int[] egArray = new int[] { 14, 1, 3, 4, 6, 6, 9, 12 };

    ArrayList<ArrayList<Integer>> a = grouping(limit, egArray);
    System.out.println(a);
}

public static ArrayList<ArrayList<Integer>> grouping(int limit, int[] array) {
    // Sort the input array.
    Arrays.sort(array);
    // Copy the int[] to an ArrayList<Integer>
    ArrayList<Integer> input = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
        input.add(array[i]);
    }

    // Initialize the groups
    ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
    groups.add(new ArrayList<Integer>());
    // Initialize the sums of the groups, to increase performance (I guess).
    ArrayList<Integer> sums = new ArrayList<>();
    sums.add(0);

    // Iterate through the input array until there is no number
    // left in it (that means we just added all the numbers
    // into our groups array).
    while (!input.isEmpty()) {
        int n = input.get(0); // Store the number to 'n', to shortcut.
        if (n > limit) {
            String msg = "number is greater than the limit; cannot add number";
            throw new IllegalArgumentException(msg);
            // Or whatever to do if the number is larger than the limit.
        }
        boolean match = false;
        // Search the next groups and check if our current
        // number ('n') fits.
        for (int i = 0; i < sums.size(); i++) {
            if (sums.get(i) + n <= limit) {
                // If it fits, then add the number to the group.
                sums.set(i, sums.get(i) + n);
                groups.get(i).add(n);
                match = true;
                break;
            }
        }
        // If 'n' doesn't fit in any group, create a new one.
        if (!match) {
            ArrayList<Integer> e = new ArrayList<>();
            e.add(n);
            groups.add(e);
            sums.add(n);
        }
        // Remove our number.
        input.remove(0);
    }
    return groups;
}