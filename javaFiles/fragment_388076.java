Optional<String> result = sentences.stream()
    .filter(str -> str.contains("home"))
    .findAny()

if (result.isPresent()) {
    return result.get();
}