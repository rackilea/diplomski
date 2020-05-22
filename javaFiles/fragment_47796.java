System.out.println("Write a name and number (separate with blankspace), end with 'q'");
while (true) {
    String full = in.nextLine();
    if ("q".equals(full)) {
        break;
    }

    String[] parts = full.split("\\s+");
    if (parts.length != 2) {
        // you could also just break here as well, but throwing an exception
        // is something you might actually do in a production code base
        throw new IllegalArgumentException("Wrong number of input terms; use 2 only");
    }

    listNames.add(parts[0]);
    listNumbers.add(Integer.parseInt(parts[1]));
}