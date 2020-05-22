public static void main(String[] args) throws Exception {
    String data = "Hello;World! My name is John. I write code.";
    String[] words = data.split("\\W+");
    String[] delimiters = data.split("\\w+");
    int delimiterIndex = 0;

    StringBuilder sb = new StringBuilder();
    for (String word : words) {
        if (word.length() < 2) {
            sb.append(word);
        } else {
            char firstLetter = word.charAt(0);
            char secondLetter = word.charAt(1);
            if (Character.isUpperCase(firstLetter)) {
                // Swap the first two letters and change casing
                sb.append(Character.toUpperCase(secondLetter))
                        .append(Character.toLowerCase(firstLetter));
            } else {
                // Swap the first two letters
                sb.append(secondLetter)
                        .append(firstLetter);
            }
            // Append the rest of the word past the first two letters
            sb.append(word.substring(2));
        }

        // Append delimiters
        if (delimiterIndex < delimiters.length) {
            // Skip blank delimiters if there are any
            while (delimiters[delimiterIndex].isEmpty()) {
                delimiterIndex++;
            }
            // Append delimiter
            sb.append(delimiters[delimiterIndex++]);
        }
    }
    data = sb.toString();

    // Display result
    System.out.println(data);
}