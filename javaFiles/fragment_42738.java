while (f < input.length()) {

    char c = input.charAt(f);
    if (c > 63) {
        forward.append(c);
    }

    f++;
}