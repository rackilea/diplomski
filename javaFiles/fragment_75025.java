public static void addToList(String input) {
    String temp;
    List<String> l = new ArrayList<>();
    for (int i = 0; i < input.length() - 1; i++) {
        if (input.charAt(i) == input.charAt(i + 1)) {
            temp = String.valueOf(input.charAt(i));
            for (int j = i; j < input.length() - 1; j++) {
                if (input.charAt(j) == input.charAt(j + 1)) {
                    temp += String.valueOf(input.charAt(j + 1));
                    if (j == input.length() - 2) {
                        i = j;
                        if (!temp.isEmpty()) {
                            l.add(temp);
                        }
                        break;
                    }
                } else {
                    i = j - 1;
                    if (!temp.isEmpty()) {
                        l.add(temp);
                    }
                    break;
                }
            }
        }
    }
    System.out.println(getHighestOccurences(l));
}

public static String getHighestOccurences(List<String> list) {
    int max = 0;
    int curr;
    String currKey = null;
    Set<String> unique = new HashSet<>(list);
    for (String key : unique) {
        curr = Collections.frequency(list, key);
        if (max < curr) {
            max = curr;
            currKey = key;
        }
    }
    return currKey;
}