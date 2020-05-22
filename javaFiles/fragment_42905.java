for (int i = 0; i < str.length(); i++) {
    int codepoint = str.codePointAt(i++);
    if (Character.isHighSurrogate(str.charAt(i))) {
        // This will fail if the UTF-16 representation of 
        // this string is wrong (e.g., high surrogate `char` 
        // at the end of the string's `char[]`).
        i += 1;
    }
    // do stuff with codepoint...
}