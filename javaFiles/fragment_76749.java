public static int counter(List<String> comments) {
    int count = 0;
    String word = "the";
    for (String comment : comments) {
        String a[] = comment.split(" ");
        for (int j = 0; j < a.length; j++) {
            if (word.equals(a[j])) {
                count++;
            }
        }
        System.out.println(comment);
    }
    System.out.println("sefsfsfseesfeseeeeeeeeeeeeeeeeeeeeeee");
    return count;
}