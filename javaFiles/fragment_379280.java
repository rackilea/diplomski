public enum Thing implements HasCaste {

    Type1 {
        @Override
        public Class<String> getCaste() {
            return String.class;
        }
    }, Type2 {
        @Override
        public Class<Integer> getCaste() {
            return Integer.class;
        }
    };
}

interface HasCaste {
    public Class<?> getCaste();
}