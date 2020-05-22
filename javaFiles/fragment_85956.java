int nrTurtles = Keyboard.nextInt("Set amount of turtles: ");

int height = 300;
w = new GraphicsWindow(500, height);

drawLinez();

double distanceBetweenTurles = (height - 100.0) / nrTurtles;

for (int k = 1; k <= nrTurtles; k++) {
    Turtle t = new Turtle(w, 50, 50 + (int) (k * distanceBetweenTurtles));
    t.right(90);
    t.setSpeed(100);
    t.penDown();
    turtles.add(t);
}