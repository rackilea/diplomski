String[] s = { "arrow" };
for (int i = 0; i < s.length; i++) {
    for (int j = 0; j < s[i].length() - 1; j++) {
        if (s[i].charAt(j) == s[i].charAt(j + 1)) {
            System.out.println("Duplicate value : " + s[i].charAt(j));
        }
    }
}