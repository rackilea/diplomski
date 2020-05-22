public enum Base {

    A {
        public char getPacked(char packed) {
            return packed;
        }
    }, T {
        public char getPacked(char packed) {
            return (char) (packed | 1);
        }
    }, C {
        public char getPacked(char packed) {
            return packed;
        }
    }, G {
        public char getPacked(char packed) {
            return packed;
        }
    };

    public abstract char getPacked(char packed);
}