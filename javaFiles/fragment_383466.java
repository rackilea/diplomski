class Animal {
    int i;

    public Animal() {
        i = 13;
    }

    @Override
    public String toString() {
        return "Animal " + i;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(i);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return ((Animal) obj).i == i;
        }
        return false;
    }
}