private <T extends Animal> T extractAnimal(JsonNode node, Supplier<T> animalSupplier) {
    T animal = animalSupplier.get();

    animal.setName(node.get("name").asText());
    animal.setAge(node.get("age").asText());

    return animal;
}