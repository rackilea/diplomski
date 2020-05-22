class ExceptionCounter {
    private int count = 0;

    void inc() { count++; }

    int getCount() { return count; }
}

ExceptionCounter counter = new ExceptionCounter();

List<Item> items = getInputs().stream()
    .map(input -> {
        try {
            return getItem(input);
        } catch (Exception e) {
            // handle exception here
            counter.inc();
        }
    })
    .collect(Collectors.toList());