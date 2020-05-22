public class Road {
    public enum LENGTH {
        NONE(0), SHORT(25), MEDIUM(50), LONG(100);
        private final int length;

        LENGTH(int length) {
            this.length = length;
        }

        public int getValue() {
            return length;
        }
    }

    public enum CURVE {
        NONE(0), EASY(2), MEDIUM(4), HARD(6);
        private final int curve;

        CURVE(int curve) {
            this.curve = curve;
        }

        public int getValue() {
            return curve;
        }
    }
}