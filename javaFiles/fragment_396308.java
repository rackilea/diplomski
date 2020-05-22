private static class Feature<T> {
    final BiConsumer<Characteristics, T> setter;
    final List<T> choices;

    Feature(BiConsumer<Characteristics, T> setter, T... choices) {
        this.setter = setter;
        this.choices = Arrays.asList(choices);
    }
}

public static void main(String[] args) {
    final List<Feature<?>> features = Arrays.asList(
            new Feature<Color>(Characteristics::setColor, Color.BLUE, Color.YELLOW, Color.RED),
            new Feature<Integer>(Characteristics::setHeight, 20, 30),
            new Feature<Integer>(Characteristics::setLength, 100, 120),
            new Feature<Integer>(Characteristics::setWidth, 60, 80),
            new Feature<String>(Characteristics::setMaterial, "wood", "metal", "glass"),
            new Feature<Integer>(Characteristics::setThickness, 4, 6),
            new Feature<String>(Characteristics::setTexture, "smooth", "grainy", "velvety"),
            new Feature<Effect>(Characteristics::setEffect, new Shadow(), new BoxBlur())
    );

    int[] dimensions = features.stream().mapToInt(f -> f.choices.size()).toArray();

    List<Characteristics> chrVariants = new CartesianProduct(dimensions)
            .stream()
            .map(prod -> {
                Characteristics chr = new Characteristics();
                IntStream.range(0, prod.length)
                        .forEach(i -> {
                            Feature f = features.get(i);
                            f.setter.accept(chr, f.choices.get(prod[i]));
                        });
                return chr;
            })
            .collect(Collectors.toList());

    chrVariants.forEach(chr -> System.out.println(chr));
}