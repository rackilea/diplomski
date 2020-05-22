public static void checkAge(int[] ages) {
    List<Integer> validAges = new ArrayList<>();
    List<Integer> invalidAges = new ArrayList<>();

    for (int age : ages) {
        if (age < 18) {
            invalidAges.add(age);
        } else {
            validAges.add(age);
        }
    }

    System.out.println("Valid ages are:");
    validAges.forEach(System.out::println);

    System.out.println("Invalid ages are:");
    invalidAges.forEach(System.out::println);
}