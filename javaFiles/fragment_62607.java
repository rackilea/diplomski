private List<Movable> movables = new ArrayList<Movable>();
private List<Monster> monsters = new ArrayList<Monster>();
private void add(Monster monster) {
    monsters.add(monster);
    if (monster instanceof Movable) {
        movables.add((Movable)monster);
    }
}