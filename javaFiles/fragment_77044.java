public static String sortString(String input) {
    Scanner s = new Scanner(input);

    LinkedList<String> strings = new LinkedList<String>();
    LinkedList<Integer> integers = new LinkedList<Integer>();
    LinkedList<Boolean> types = new LinkedList<Boolean>();

    while(s.hasNext()) {
        String nextToken = s.next();
        try {
            int nextInteger = Integer.parseInt(nextToken);
            integers.add(nextInteger);
            types.add(true);
        } catch(NumberFormatException e) {
            strings.add(nextToken);
            types.add(false);
        }
    }

    Collections.sort(strings);
    Collections.sort(integers);

    StringBuilder builder = new StringBuilder();

    Iterator<Boolean> iter = types.iterator();

    while(iter.hasNext()) {
        boolean currType = iter.next();
        if (currType) {
            builder.append(integers.remove(0));
        } else {
            builder.append(strings.remove(0));
        }
        if (iter.hasNext()) builder.append(" ");
    }

    return builder.toString();
}