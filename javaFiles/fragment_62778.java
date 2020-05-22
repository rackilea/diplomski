class WarriorKing extends Character implements Warrior, King {
    private King kingImpl;
    private Warrior warriorImpl;

    public WarriorKing() {
        kingImpl = new KingImpl();
        warriorImpl = new WarriorImpl();

    }