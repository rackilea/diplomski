if (laststringa != null) {
    String[] arr = laststringa.split("\\s+");
    System.out.println(arr[arr.length - 1]);
} else {
    System.out.println("No Words");
}