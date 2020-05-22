public class Tag {

private int x, y;

public Tag(int x, int y) {
    this.x = x;
    this.y = y;
}

public boolean equals(Tag tag) {
    if (x != tag.x) return false;
    return y == tag.y;
}

@Override
public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
}
}