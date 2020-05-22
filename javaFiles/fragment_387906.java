public void foo(){
  Scanner scan = new Scanner(system.in);
  char c = scan.nextChar();
  if (c != '.') {
    foo();
    System.out.print(c);
  }
}