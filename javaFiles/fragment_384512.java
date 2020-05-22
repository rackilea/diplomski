String[] numbers = { "2.1.0.0", "2.1.1.0", "2.1.11.0", "2.1.12.0",
        "2.1.13.0", "2.1.14.0", "2.1.15.0", "2.1.2.0", "2.1.3.0",
        "2.1.4.0", "2.1.5.0", "2.1.6.0", "2.1.7.0", "2.1.8.0",
        "2.1.9.0" };

Arrays.sort(numbers, MyStringComparator.INSTANCE);

for (String number : numbers) {
    System.out.println(number);
}