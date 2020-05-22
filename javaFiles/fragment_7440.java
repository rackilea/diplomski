for (int i = 0; i < check.length(); i++) {
    for (int v = 0; v < vowel.length; v++) {
        if (check.charAt(i) == vowel[v]) {
            counter[v]++;
            break;
        }
    }
}