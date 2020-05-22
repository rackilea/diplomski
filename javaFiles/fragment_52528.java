public enum PAGE{
        SIGN_CREATE(0),
        SIGN_CREATE_BONUS(1),
        HOME_SCREEN(2),
        REGISTER_SCREEN(3);

        private final int value;

        PAGE(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
    }