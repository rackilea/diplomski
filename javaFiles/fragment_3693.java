public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    Example e = new Example();
    e.permutation(list, "", result);
    ...
}

private void permutation(List<String> list, String prefix, String str) {
    int n = str.length();
    if (n == 0) {
        System.out.println(prefix);
        list.add(prefix);
    } else {
        for (int i = 0; i < n; i++) {
            permutation(list, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}