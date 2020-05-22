// Note the Map type change to Double!
HashMap<String, Double> typeToAvgAttack = new HashMap<String, Double>();

// Intermediate map to store list of all attack values per type
HashMap<String, List<Integer>> typeToAttack = new HashMap<String, List<Integer>>();

for (Pokemon pokemon: pokemonList) {
    String type = pokemon.getType();
    int attack = pokemon.getAttack();

    // the map is empty at start, we need to check for the keys (pokemon type) existance
    List<Integer> attackValues = typeToAttack.get(type); 
    if (attackValues == null) {
        typeToAttack.put(type, attackValues = new ArrayList());
    }
    attackValues.add(attack);
}

// Iterate over map keys to calculate the average
for (String type : typeToAttack.keySet()) {
    List<Integer> attackValues = typeToAttack.get(type);
    double average = calculateAverage(attackValues);
    typeToAvgAttack.put(type, average);
}