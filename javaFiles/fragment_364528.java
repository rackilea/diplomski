@Override
public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (o == null || getClass() != o.getClass()) {
        return false;
    }
    A a = (A) o;
    return x == a.x &&
            y == a.y;
}

@Override
public int hashCode() {
    return Objects.hash(x, y);
}