public enum Color {

    RED(true),
    YELLOW(true),
    BLUE(true),
    ORANGE(false),
    PURPLE(false),
    GREEN(false),
    WHITE(false);

    static {
        ORANGE.components.add(RED);
        ORANGE.components.add(YELLOW);

        PURPLE.components.add(RED);
        PURPLE.components.add(BLUE);

        GREEN.components.add(YELLOW);
        GREEN.components.add(BLUE);

        WHITE.components.add(RED);
        WHITE.components.add(YELLOW);
        WHITE.components.add(BLUE);    
    }

    private boolean primary;
    private List<Color> components;

    Color(boolean primary) {
        this.primary = primary;
        this.components = new ArrayList<Color>();
    }

    public boolean isPrimary() {
        return primary;
    }

    public Set<Color> components() {
         return Collections.unmodifiableSet(this.components);
    }
}