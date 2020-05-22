public Builder withColors(List<String> colors) {
    this.colors = Optional.ofNullable(colors).map(
        list -> list.stream()
                    .filter(Objects::nonNull)
                    .map(color-> Color.valueOf(color))
                    .collect(Collectors.toList()))
                    .orElse(null);
    return this;
}