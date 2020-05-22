public enum Profession {
    BARBARIAN   (Save.POOR, Save.GOOD, Save.POOR),
    BARD        (Save.GOOD, Save.POOR, Save.GOOD),
    CLERIC      (Save.GOOD, Save.GOOD, Save.POOR);

    private final Save will;
    private final Save fortitude;
    private final Save reflex;

    Profession(Save will, Save fortitude, Save reflex) {
        this.will = will;
        this.fortitude = fortitude;
        this.reflex = reflex;
    }

    public int willModifier(int level) {
        return will.modifier.apply(level);
    }

    public int fortitudeModifier(int level) {
        return fortitude.modifier.apply(level);
    }

    public int reflexModifier(int level) {
        return reflex.modifier.apply(level);
    }

    private enum Save {

        GOOD(level -> level / 2 + 2),
        POOR(level -> level / 3);

        private final Function<Integer, Integer> modifier;

        Save(Function<Integer, Integer> modifier) {
            this.modifier = modifier;
        }

    }

}