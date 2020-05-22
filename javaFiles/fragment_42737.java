while (input.charAt(f) > 63) {
    forward.append(input.charAt(f));

    // This next line might increase f past the end of the string.
    f++;
}