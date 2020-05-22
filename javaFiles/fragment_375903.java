import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JApplet;
import javax.swing.JPanel;

public class Checkers extends JApplet {

    @Override
    public void init() {
        add(new Board());
    }

    public class Board extends JPanel {

        private final int APP_WIDTH = 400;
        private final int APP_HEIGHT = 400;
        private final int MAXSIZE = 8;

        Square[][] sq;

        @Override
        public void invalidate() {
            fillBoard();
            super.invalidate(); 
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    sq[row][col].draw(g);
                }
            }
            setBackground(Color.white);
            placeCheckers(g, 7, Color.red);   //method to place the red checkers
            placeCheckers(g, 9, Color.black); //method to draw  black checkers
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(APP_WIDTH, APP_HEIGHT);
        }

        public void fillBoard() {
            sq = new Square[8][8];

            int x, y;
            Color rb;

            int gridSize = Math.min(getWidth(), getHeight());
            int size = gridSize / MAXSIZE;

            for (int row = 0; row < MAXSIZE; row++) {
                for (int col = 0; col < MAXSIZE; col++) {
                    x = row * (gridSize / MAXSIZE);
                    y = col * (gridSize / MAXSIZE);
                    if ((row % 2) == (col % 2)) {
                        rb = Color.red;
                    } else {
                        rb = Color.black;
                    }
                    sq[row][col] = new Square(x, y, rb, size);
                }
            }

        }

        public void placeCheckers(Graphics page, int num_checkers, Color ncolor) {
            int count, row, col;
            int x, y;
            Circle c;

            int gridSize = Math.min(getWidth(), getHeight());
            int size = gridSize / MAXSIZE;

            Random rand = new Random();

            for (count = 0; count < num_checkers; count++) {
                do {
                    row = rand.nextInt(8);
                    col = rand.nextInt(8);
                } while (sq[row][col].getOccupy() || ncolor == sq[row][col].getColor());

                x = row * (gridSize / MAXSIZE);
                y = col * (gridSize / MAXSIZE);

                c = new Circle(x, y, size, ncolor);

                c.draw(page);

                sq[row][col].setOccupy(true);
            }
        }

    }

    class Square {

        private int x, y = 0;
        private Color c;
        private boolean occupied;
        private int size;

        public Square(int x, int y, Color c, int size) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.size = size;
        }

        public void setX(int x) {
            x = this.x;
        }

        public int getX() {
            return x;
        }

        public void setY(int y) {
            y = this.y;
        }

        public int getY() {
            return y;
        }

        public void setColor(Color c) {
            c = this.c;
        }

        public Color getColor() {
            return c;
        }

        public void setOccupy(boolean occupied) {
            occupied = this.occupied;
        }

        public boolean getOccupy() {
            return occupied;
        }

        public String toString() {
            return ("X coordinate: " + x + "\nY coordinate:" + y + "\nSquare color: " + c);
        }

        public void draw(Graphics page) {
            page.setColor(c);
            page.fillRect(x, y, size, size);
        }
    }

    class Circle {

        private int x, y;
        private int diameter;
        private Color c;

        public Circle(int x, int y, int diameter, Color c) {
            this.x = x;
            this.y = y;
            this.diameter = diameter;
            this.c = c;
        }

        public void setX(int x) {
            x = this.x;
        }

        public int getX() {
            return x;
        }

        public void setY(int y) {
            y = this.y;
        }

        public int getY() {
            return y;
        }

        public void setColor(Color c) {
            c = this.c;
        }

        public Color getColor() {
            return c;
        }

        public void setDiameter(int x) {
            diameter = x;
        }

        public void draw(Graphics page) {
            page.setColor(c);
            page.fillOval(x, y, diameter, diameter);
        }

    }
}