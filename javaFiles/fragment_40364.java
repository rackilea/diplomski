Map<String,Level2> children = new HashMap<>();
final String name;

public Level1(String name) {
    // add to the pool or use the existing reference to 
    // avoid duplicating information
    this.name = name.intern();
}

@Override
public boolean equals(Object o) {
    if (o == null) return false;
    if (this == o) return true;
    if (getClass() != o.getClass()) return false;
    Level1 other = (Level1) o;
    // assuming name is never null
    return other.name.equals(name);
}

@Override
public int hashCode() {
    return level1String.hashCode();
}