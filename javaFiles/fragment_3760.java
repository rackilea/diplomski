public class A {
    public static class B {
        String str;
        int i1;
        int i2;

        public B(String str, int i1, int i2) {
            this.str = str;
            this.i1 = i1;
            this.i2 = i2;
        }

        @Override
        public String toString() {
            return String.format("%-10s%4d%4d", str, i1, i2);
        }
    }

    private Collection<B> coll;

    // in most cases avoid underscore in names, especailly names in the public interface of a class
    public A(Collection<B> coll) {
        this.coll = coll;
        // or may make a "defensive copy" so that later changes to the collection passed in doesn’t affect this instance
        // this.coll = new ArrayList<>(coll);
    }

    public void printAll() {
        // Requirements said "print all data using a loop", so do that
        for (B bInstance : coll) {
            System.out.println(bInstance);
            // may also access variables from B, for instance like:
            // System.out.println(bInstance.str + ' ' + bInstance.i1 + ' ' + bInstance.i2);
        }
    }
}