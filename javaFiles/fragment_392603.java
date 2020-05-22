List<Square> squares = new ArrayList<>();
Point p  = new Point((int)(x),      (int) (y)           );
Point p1 = new Point((int)(x+side), (int)(y)            );
Point p2 = new Point((int)(x+side), (int) (y-side)      );
Point p3 = new Point((int)(x),      (int)(y-side)       );
Square s = new Square(p, p1, p2, p3);

squares.add(s);
for (int i = 1; i < 20; i++) {
    s = s.nextSquare();
    squares.add(s);
}