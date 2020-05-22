public static void checkAge(int[] ages) {
    for (int age : ages) {
        if (age < 18) {
            System.out.println(age + " invalid age");
        } else {
            System.out.println(age + " valid age");
        }
    }
}