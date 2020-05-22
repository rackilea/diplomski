enum Bar {
    NORMAL, CUSTOM {
        @Override
        public String toString() {
            return "different";
        }
    };
}