final Random rand = new Random();

final static Class<?>[] units = {Destroyer.class, Cruiser.class, AegisCruiser.class};

public Unit newRandomUnit() throws InstantiationException, IllegalAccessException {
    final Class<?> selectedUnitClass = units[rand.nextInt(units.length)];
    return (Unit)selectedUnitClass.newInstance();
}