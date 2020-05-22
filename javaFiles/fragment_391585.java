public void method(int userInput) {
    // validate userInput
    Weekdays[] values = Weekdays.values();

    for (int i = userInput; i < values.length + userInput; ++i) {
        Weekdays day = values[i % values.length];
        System.out.println(day.getFullName());
    }
}