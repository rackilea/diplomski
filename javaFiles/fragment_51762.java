interface Function<A, B> {
        B map(A a);
    }

    class ListUtil {
        public static <A, B> List<B> map(Function<A, B> function, List<A> aList) {
            List<B> bList = new ArrayList<>();
            for (A a : aList) {
                bList.add(function.map(a));
            }
            return bList;
        }
    }