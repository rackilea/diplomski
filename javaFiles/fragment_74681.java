class Main {
    public static void main(String[] args) {
        int multiple_characters = 0;
        int i;
        String array1[] = { "abc", "aabc", "xyyyxy" };
        for (int index = 0; index < array1.length; index++) {
            System.out.println("String: " + array1[index]);
            for (i = 0; i < array1[index].length() - 1; i++) {
                multiple_characters = 1;
                while (array1[index].charAt(i) == array1[index].charAt(i + 1) && i < array1[index].length() - 1) {
                    multiple_characters++;
                    i++;
                }
                System.out.println(array1[index].charAt(i) + " has been repeated consecutively " + multiple_characters
                        + " time(s)");
            }
            if (multiple_characters == 1) {
                System.out.println(array1[index].charAt(i) + " has been repeated consecutively 1 time(s)");
            }
            System.out.println("------------");
        }
    }
}