class Encounter {
    private final Hero mainHero;
    private final List<Hero> participants;

    public Encounter(Hero mainHero) {
        this.mainHero = mainHero;
        participants = new ArrayList<>();
    }

    public void addParticipant(Hero hero) {
        participants.add(hero);
    }
}