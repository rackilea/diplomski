for (Map.Entry<String, String> entry : alphabet.entrySet()) {
    // TODO: Should this be source.charAt(i)?
    if (entry.getKey().equals(source.charAt(0))) {
        source.setCharAt(i, entry.getValue().charAt(0));
    }
}