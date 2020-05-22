interface Comp extends Comparable<Comp> {}

public class TypeTypeComparator<T extends Comp> {

    public T t1;
    public T t2;

    public TypeTypeComparator() {
        this.t1 = null;
        this.t2 = null;
    }

    public TypeTypeComparator(T t1, T t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public static enum Comparator implements java.util.Comparator<TypeTypeComparator<Comp>> {
        T1_SORT {
            @Override
            public int compare(TypeTypeComparator<Comp> o1,
                    TypeTypeComparator<Comp> o2) {
                return o1.t1.compareTo(o2.t1);
            }
        },
        T2_SORT {
            @Override
            public int compare(TypeTypeComparator<Comp> o1,
                    TypeTypeComparator<Comp> o2) {
                return o1.t2.compareTo(o2.t2);
            }
        };

        public static java.util.Comparator<TypeTypeComparator<Comp>> getComparator(final Comparator... options) {
            return new java.util.Comparator<TypeTypeComparator<Comp>>() {
                public int compare(TypeTypeComparator<Comp> o1, TypeTypeComparator<Comp> o2) {
                    for ( Comparator option : options ) {
                        int result = option.compare(o1, o2);
                        if ( result != 0 )
                            return result;
                    }
                    return 0;
                }
            };
        }
    }
}