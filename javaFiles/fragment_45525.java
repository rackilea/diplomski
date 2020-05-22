class MoonRegistry {

    private final Map<String, Class<? extends Enum>> 
              planetMoonTypes = new HashMap<>();

    {
        this.registerEnum("Saturn", Saturn.class);
        this.registerEnum("Mars", Mars.class);
    }

    public <T extends Enum<T> & Moon> void registerEnum(
            String planetName, Class<T> cls) {
        this.planetMoonTypes.put(planetName, cls);
    }

    public Moon findByPlanetAndName(String planet, String name) {
        return (Moon) Enum.valueOf(this.planetMoonTypes.get(planet), name);
    }
}