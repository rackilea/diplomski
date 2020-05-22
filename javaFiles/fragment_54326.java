Num num = new  Num() {

        Double d;

        @Override
        public void neg() {
            d = -d;
        }

        @Override
        public void sqrt() {
            d = Math.sqrt(d);
        }

        @Override
        public String asString() {
            return d.toString();
        }

    };