public static void checkAge(int[] ages) {
    List<Integer> invalidAges = new ArrayList<>();
    for (int i = 0; i < ages.length; i++) {
        if (ages[i] < 18) {
            invalidAges.add(ages[i]);
        } else {
            System.out.println(ages[i] + " valid age");
        }
    }

    // Print invalid ages
    for (int invalidAge : invalidAges) {
        System.out.println(invalidAge + " is invalid age");
    }
}