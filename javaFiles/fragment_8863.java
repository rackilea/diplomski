public enum Modes {
    mode1 ("Fancy Mode 1"),
    mode2 ("Fancy Mode 2"),
    mode3 ("Fancy Mode 3");

    private final String name;       

    private Modes(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false 
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}