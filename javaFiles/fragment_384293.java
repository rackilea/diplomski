public static void Search(String[] arr, String find) {
    for (int i = 0; i < 10; i++) {
        if (arr[i].toLowerCase().contains(find.toLowerCase())) {
             System.out.println(String.format("found name: %s", arr[i]));
             return;
        }
    }
    System.out.println("Name not found!");
}