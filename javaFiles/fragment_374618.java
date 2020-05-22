public static void main(String[] args) {
    var createdArray = new AtomicReference<String[]>();
    var usedArray = List.of("A", "B", "C").toArray(__ -> {
        createdArray.set(new String[5]);
        return createdArray.get();
    });

    var message = String.format(
            "%s (length: %d; identical with created array: %s)",
            Arrays.toString(usedArray), usedArray.length, usedArray == createdArray.get());
    System.out.println(message);
}