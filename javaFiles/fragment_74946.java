public void main(String... args) throws Exception {
  Scanner console = ...;
  System.out.println("Type a:");
  Double a = Double.parseDouble(console.nextLine());
  // Same for b and c
  Parabola p = new Parabola(a, b, c);
  System.out.println("X axis intersected in "  + p.x1() + " and " + p.x2());
}