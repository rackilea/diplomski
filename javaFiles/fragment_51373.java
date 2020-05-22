public static void main(String[] args) {
    Collection<Bee> bees = new ArrayList<Bee>();
    bees.add(new Hive.Worker());
    bees.add(new Hive.Queen());
    Set<Queen> queens = getBeesOfOneType(bees, Queen.class);
}

private static <T extends Bee> Set<T> getBeesOfOneType(Collection<Bee> bees, Class<T> beeType) {
    Set<T> result = new HashSet<T>();
    for (Bee bee : bees) {
        if (beeType.isInstance(bee)) {
            // The following cast is safe. The previous if makes sure that
            // that bee can be cast to T at this place
            T beeTypeInstance = beeType.cast(bee);
            result.add(beeTypeInstance);
        }
    }
    return result;
}