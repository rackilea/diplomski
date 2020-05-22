@Override
public int compareTo(Square other) {
    int cmp = super.compareTo(other);
    // don't do this!
    if (cmp == 0 && (other instanceof ColorSquare)) {
        ColorSquare otherColor = (ColorSquare) other;
        cmp = color.compareTo(otherColor.color);
    }
    return cmp;
}