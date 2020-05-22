final Random rand = new Random();

enum UnitType {
    Destroyer, Cruiser, AegisCruiser
}

public Unit newRandomEnumUnit() throws Exception {
    final UnitType selectedUnitType = UnitType.values()[rand.nextInt(UnitType.values().length)];
    switch (selectedUnitType) {
    case Destroyer:
        return new Destroyer();
    case Cruiser:
        return new Cruiser();
    case AegisCruiser:
        return new AegisCruiser();
    default:
        throw new Exception("Unit type not found !");
    }
}