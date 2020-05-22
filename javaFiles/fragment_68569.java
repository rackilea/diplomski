public static void main(String[] args) {
    CreateShape temp = new CreateShape(6, 6, 'a', new char[][]{{'x', '.', 'a'},
        {'.', '.', 'b'},
        {'x', '.', 'c'}}, "x . a\n"
        + ". . b\n"
        + "x . c");
    temp.rotateCW();
    System.out.println(temp);
    temp.rotateCW();
    System.out.println(temp);
    temp.rotateCW();
    System.out.println(temp);
  }