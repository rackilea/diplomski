public class Test001 {

        private int x;

        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setXY(int x, int y) {
            setX(x);
            setY(y);
        }

        public int[] getXY() {
            return new int[] { x, y };
        }

    }