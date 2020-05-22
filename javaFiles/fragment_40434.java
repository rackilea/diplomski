XVector position = new XVector();
IntStream.range(0, DESIRED_STAR_COUNT).forEach(a -> {
    // Try to find a position outside the margin of other stars.
    IntStream.range(0, PATIENCE).filter(b -> {
        position.random(size);
        return !this.positions.stream().anyMatch(point -> position.sub(point).getMagnitude() < MIN_STAR_MARGIN);
    }).findFirst().ifPresent(b -> {
        this.positions.add(position.copy());
        this.colors.add((XColor) XRandom.sChoice(RED_STAR, BLUE_STAR));
    });
});