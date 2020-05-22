public static void main(String[] args) {
    String[] arr = { "All-Inclusive,All Inclusive", "Luxury,Luxury",
            "Spa-And-Relaxation,Spa & Relaxation" };
    String[] first = new String[arr.length];
    String[] second = new String[arr.length];
    for (int i = 0; i < arr.length; i++) {
        String[] t = arr[i].split("\\s*,\\s*");
        if (t.length == 2) {
            first[i] = t[0];
            second[i] = t[1];
        }
    }
    System.out.printf("First = %s%n", Arrays.toString(first));
    System.out.printf("Second = %s%n", Arrays.toString(second));
}