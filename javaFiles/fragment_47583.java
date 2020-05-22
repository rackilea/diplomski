@Override
public boolean equals(Object o) {
    System.out.println("equals ColorPoint");
    if (!(o instanceof ColorPoint))
        return false;
    return super.equals(o) && ((ColorPoint) o).color == color;
}