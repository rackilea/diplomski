String delimiters = "?!.";
int count = 0;
for (int i = 0; i < line.length(); i++) {
    if (i == 0 || line.charAt(i) != line.charAt(i - 1)) {
        if (delimiters.indexOf(line.charAt(i)) != -1) {
            count++;
        }
    }
}