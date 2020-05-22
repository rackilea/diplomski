public void contactsByNumber(String number) {
    phoneNumbers.stream()
                .parallel()
                .map(PhoneNumber::getName)
                .filter(number::contains)
                .forEach(System.out::println);
}