int j = 0;
for (int i = 0; i < words.length; i++) {
    if (words[i].substring(0, prefix.length()).equalsIgnoreCase(prefix)) {
        returnWords[j] = words[i];
        j++;
    }
}