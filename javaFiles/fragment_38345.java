@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Ghost))
        return false;

    // Cast Object to Ghost so the comparison below will work
    Ghost other = (Ghost) obj;

    return this.x == other.x
        && this.y == other.y
        && this.direction == other.direction
        && this.color.equals(other.color);
}