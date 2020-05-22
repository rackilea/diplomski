int x = 5;

public void unsafe() {
  x = 5;
  x = x + 5;
  return x;
}