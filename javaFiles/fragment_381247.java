enum HashCodeMethod {
    GUAVA {
        @Override
        public int hashCode(Multiset<?> multiset) {
            return multiset.hashCode();
        }
    },
    RINKE {
        @Override
        public int hashCode(Multiset<?> multiset) {
            int result = 0;
            for (final Object o : multiset.elementSet()) {
                result += (o==null ? 0 : o.hashCode()) * multiset.count(o);
            }
            return result;
        }
    },
    MAAARTIN {
        @Override
        public int hashCode(Multiset<?> multiset) {
            int result = 0;
            for (final Multiset.Entry<?> e : multiset.entrySet()) {
                result += (e.getElement()==null ? 0 : e.getElement().hashCode()) * (2*e.getCount()+123);
            }
            return result;
        }
    }
    ;
    public abstract int hashCode(Multiset<?> multiset);
}