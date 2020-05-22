class Triangle {
    private int[] sides;

    public Triangle(int x, int y, int z) {
        sides = new int[] {x,y,z};
        Arrays.sort(sides);
    }

    @Override public boolean equals(Object o) {
        return o instanceof Triangle && Arrays.equals(sides, ((Triangle) o).sides);
    }

    @Override public int hashCode() {
        return Arrays.hashCode(sides);
    }

    @Override public String toString() {
        return Arrays.toString(sides);
    }
}