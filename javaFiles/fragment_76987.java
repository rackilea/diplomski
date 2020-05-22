List<MyException> caughtExceptions = new ArrayList<>();

lines.forEachOrdered(line -> {
    try {
        process(line);
    } catch (MyException e) {
        caughtExceptions.add(e);
    }
});

if (caughtExceptions.size() > 0) {
    throw caughtExceptions.get(0);
}