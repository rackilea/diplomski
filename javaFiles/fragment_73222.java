class Foo <T> {

        private Foo (){}

        public static Foo<?> createFoo (boolean b){
            return b ? new Foo<Integer>() : new Foo<Double>();
        }
    }