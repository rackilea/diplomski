public static A getValueA() {
    return new A() {
        // Will not work with getValue marked final
        @Override
        public int getValue() {
            return 4;
        }
    };
}