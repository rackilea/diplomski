// I assume other is "contained" in this
public Level1 merge(Level1 other) {
    Level1 result = new Level1("root");
    for (Level2 child : other.children) {
        // cannot be null if other is contained in this
        Level2 corresponding = children.get(child.name);
        corresponding.children.putAll(child.children);
    }
}