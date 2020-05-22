String convSummary2(String s) {
    StringBuilder sb = new StringBuilder();
    s.chars().map(Character::toLowerCase).forEach(c -> {
        if ('a' <= c && c <= 'e') {
            sb.append((char)(c & 0x5f));
        } else if ('v' <= c && c <= 'z') {
            sb.append((char) c);
        }
    });
    return sb.toString();
}