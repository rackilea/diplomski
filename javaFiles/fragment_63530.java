public static void main(String[] args) throws Exception {
    final String in = "9,6,4,3,22,12,7,8,44,33,21,19,26,48,55,61,15,14,2,61,27,76,79,84,93";
    final SortedSet<Integer> inputs = new TreeSet<>();
    boolean dup = false;
    for (final String s : in.split(",")) {
        if (!inputs.add(Integer.parseInt(s))) {
            dup = true;
        }
    }
    if (dup) {
        System.out.println("There were duplicates");
    } else {
        System.out.println("There were no duplicates");
    }
    System.out.println("The highest number is " + inputs.last());
    System.out.println("The lowest number is " + inputs.first());
    final Iterator<Integer> iter = inputs.iterator();
    for (int i = 0; iter.hasNext(); ++i) {
        System.out.println(i + " -> " + iter.next());
    }
}