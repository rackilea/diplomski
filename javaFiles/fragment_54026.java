String input = "[\"abc\", \"xyz\", \"123\"]"

// Remove the [ and ]
input = input.substring(1, input.length() - 1);
String[] words = input.split(", ");
// Remove the quotation marks
for (int i = 0; i < words.length; i++) {
    words[i] = words[i].substring(1, words[i].length() - 1);
}