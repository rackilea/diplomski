Set<Integer> results = new HashSet<>();
for (String part : field.getText().split(",")) {
    String trimmed = part.trim();
    if (trimmed.isEmpty()) continue;
    results.add(Integer.valueOf(trimmed));
}