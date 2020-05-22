static <T> Predicate<T> p(Predicate<? super T> isUnknown, Predicate<? super T> isTrue){
    return new Predicate<T>(){
        @Override
        public boolean test(T t) {
            return isUnknown.test(t) || isTrue.test(t);
        }
        @Override
        public Predicate<T> negate(){
            return p(isUnknown, isTrue.negate());
        }
    };
}