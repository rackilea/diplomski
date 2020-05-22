abstract class Piece {

        java.awt.Color color;
        String name;
        int x, y;

        Piece(java.awt.Color color, String name) {
            this.color = color;
            this.name = name;

        }

        @Override
        public String toString() {
            return "Piece{" +
                    "color=" + color +
                    ", name='" + name + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

class Knight extends Piece {

        Knight(Color color, String name) {
            super(color, name);
        }

        @Override
        public boolean equals(Object obj) {
            Knight that = (Knight) obj;
            return this.color == that.color && this.name.equals(that.name);
        }
    }