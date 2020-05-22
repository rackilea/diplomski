public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter Word: ");
    List<String> inputList = new ArrayList<String>();
    String input = scan.next();
    permutation(input, inputList);

    System.out.println(inputList);

}

public static void permutation(String str, List<String> result) {
    permutation("", str, result);
}

private static void permutation(String prefix, String str,
        List<String> container) {
    int n = str.length();
    if (n == 0) {
        container.add(prefix);
    } else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i),
                    str.substring(0, i) + str.substring(i + 1, n),
                    container);
    }
}