public class Main {
    public static class Key {
        private final int k;
        public Key(int k) {
            this.k = k;
        }
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key rhs = (Key)obj;
            return k == rhs.k;
        }
        @Override
        public int hashCode() {
            //...
            return 0;
        }
    }
    public static class Data extends Key {
        private final int d;
        public Data(int k, int d) {
            super(k);
            this.d = d;
        }
    }
    public static void main(String[] args) {
        List<Data> l = new ArrayList<Data>();
        l.add(new Data(123, 456));
        l.add(new Data(42, 24));
        System.out.println(l.contains(new Key(789)));
        System.out.println(l.contains(new Key(123)));
        System.out.println(l.contains(new Key(42)));
    }
}