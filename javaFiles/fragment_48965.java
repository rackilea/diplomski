class CarOne extends Car { // extends my version of Car...

    private static Color COLOR = Color.Red;
    private static int CYLINDERS = 4;

    public CarOne() {
      setColor(COLOR);
      setNumCylinders(CYLINDERS );
    }

    // getters deleted, base class has them now
}