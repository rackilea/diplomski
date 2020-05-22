public static int findLevel(List<Plants> plants, int id) {
    if (plants == null) {
        throw new IllegalArgumentException("plants list must not be NULL");
    }
    Plants foundPlant = null;
    for (Plants plant: plants) {
        if (plant.getID() == id) {
            foundPlant = plant;
            break;
        }
    }
    if (foundPlant == null) {
        throw new IllegalArgumentException("There is no such Plant with the given Id");
    }
    return foundPlant.getLevel();
}