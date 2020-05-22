if (circle.contains(event.getX(), event.getY())) {
    circle.setFill(Color.BLACK); // <-- so it is black
    if (circle.getFill().equals(Color.BLACK)) // <-- uhh..it is black..let's change to yellow
         circle.setFill(Color.YELLOW);
    else if (circle.getFill().equals(Color.BLUE))
         circle.setFill(Color.BROWN);
    else if (circle.getFill().equals(Color.YELLOW))
         circle.setFill(Color.BROWN);
    else if (circle.getFill().equals(Color.BROWN))
         circle.setFill(Color.BLACK);
}