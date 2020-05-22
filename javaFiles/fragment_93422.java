public static class PlanetSpecies {
    Planet planet;
    Set<Species> species;

    public PlanetSpecies(Planet planet, Set<Species> species) {
        this.planet = planet;
        this.species = species;
    }

    public Planet getPlanet() {
        return planet;
    }

    public Set<Species> getSpecies() {
        return species;
    }
}