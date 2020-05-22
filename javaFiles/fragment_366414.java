Object o = Objects.getObject(2dCoordinates);
Entity e = as(Entity.class, o);
if (e != null) {
    Army a = as(Army.class, e);
    if (a != null)
    a.armySpecificMethod();
}