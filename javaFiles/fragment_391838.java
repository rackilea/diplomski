public class MyAtomicLongExample {

    static class MyAtomicLong extends AtomicLong {

        private static final long serialVersionUID = -8694980851332228839L;

        public MyAtomicLong(long initialValue) {
            super(initialValue);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof MyAtomicLong && ((MyAtomicLong) obj).get() == get();
        }
    }

    public static void main(String[] args) {
        Map<String, MyAtomicLong> atomicMap = new HashMap<>();
        atomicMap.put("Ron", new MyAtomicLong(0l));
        atomicMap.put("David", new MyAtomicLong(0l));
        atomicMap.put("Fredrick", new MyAtomicLong(0l));
        atomicMap.put("Gema", new MyAtomicLong(1l));
        atomicMap.put("Andrew", new MyAtomicLong(1l));    

        atomicMap.values().removeAll(Collections.singleton(new MyAtomicLong(0l)));

        System.out.println(atomicMap);
    }

}