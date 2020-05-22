static <T> Predicate<T> p(Predicate<? super T> o){ //(I'm not sure what to name this)
    return new Predicate<T>(){
        @Override
        public boolean test(T t) {
            return t == null || o.test(t);
        }
        @Override
        public Predicate<T> negate(){
            return p(o.negate());
        }
    };
}
....
Predicate<String> predicate = p(t -> !"0".equals(t));