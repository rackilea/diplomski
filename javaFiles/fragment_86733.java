public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int d = 0; d < words.size(); d++) {
        sb.append("The word: ").append(words.get(d)) //
                .append(System.lineSeparator());
    }
    return sb.toString();
}