public enum Specialization {
    PHYSICS('p', "Physics"),
    CHEMISTRY('c', "Chemistry"),
    BIOLOGY('b', "Biology");

    private char menuLetter;
    private String displayName;

    private Specialization(char menuLetter, String displayName) {
        this.menuLetter = menuLetter;
        this.displayName = displayName;
    }

    public char getMenuLetter() { return menuLetter; }

    public String getDisplayName() { return displayName; }
}