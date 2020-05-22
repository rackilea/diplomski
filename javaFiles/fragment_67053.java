for (int i = 0; i < dice.length;) {
  System.out.print("(");
  do {
    System.out.print(dice[i]);
  } while (++i < dice.length && dice[i] == dice[i-1]);
  System.out.print(")");
}