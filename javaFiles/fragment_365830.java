enum CoffeeSize {
    BIG(1){
        @Override
        public String getLidCode() {
            return "C";
        }
    },
    HUGE(2) {
        @Override
        public String getLidCode() {
            return "B";
        }
    },
    OVERWHELMING(3) {
        @Override
        public String getLidCode() {
            return "A";
        }
    };
    ...
}