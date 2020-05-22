public final class HashSetDemo {
    private final int age;

    public HashSetDemo(int age) {
        this.age = age;
    }

    @Override public int hashCode() {
        return age;
    }

    @Override public boolean equals(Object other) {
        if (!(other instanceof HashSetDemo)) {
           return false;
        }
        HashSetDemo otherDemo = (HashSetDemo) other;
        return age == otherDemo.age;
    }
}