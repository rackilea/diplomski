String getTheMostExpensiveIngredient(Map<Ingredient, Double> map) {
    return map.entrySet().stream() // Stream<Map.Entry<Ingredient, Double>>
            .max(Comparator.comparingDouble(
                    e -> e.getValue() * e.getKey().getPrice())) // Optional<Map.Entry<..>>
            .map(e -> e.getKey().getName()) // Optional<String>
            .orElse(null);                  // just String
}