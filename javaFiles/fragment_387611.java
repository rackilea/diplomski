private double toDouble(final Editable editable) {
    final String content = editable.toString();
    if (content.isEmpty()) {
        return 0;
    }
    return Double.parseDouble(content);
}