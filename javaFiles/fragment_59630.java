// Our input string.
String input = "I love fish";

// Contains the "encrypted" output string.
StringBuilder encrypted = new StringBuilder();

// Process each character in the input string.
for (char c : input.toCharArray()) {
    if (Character.toLowerCase(c) != 'a' && Character.isLetter(c)) {
        // If the character is a letter that's not 'a', convert it to the previous letter.
        char previous = (char) ((int) c - 1);
        encrypted.append(previous);
    } else {
        // Otherwise just append the original character.
        encrypted.append(c);
    }
}

// Prints the output to stdout.
System.out.println(encrypted.toString());