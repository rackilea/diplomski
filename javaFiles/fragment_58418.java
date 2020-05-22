public Set<String> getInputs(final JTextComponent component) {
    final Set<String> inputs = new LinkedHashSet<>();
    for (final String input : component.getText().split("\\s+")) {
        inputs.add(input);
    }
    return inputs;
}