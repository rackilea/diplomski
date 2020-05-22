private static int solutions(int num, int x1, int x2, int x3)
{
  if (x1 > 10 || x1 > num)
    return 0;
  if (x2 > 10 || x1+x2 > num)
    return solutions(num, x1+1, 1, 1);
  if (x3 > 10 || x1+x2+x3 > num)
    return solutions(num, x1, x2+1, 1);

  int me = 0;
  if (x1+x2+x3 == num) {
    System.out.printf("%d + %d + %d\n", x1, x2, x3);
    me=1;
  }
  return me + solutions(num, x1, x2, x3+1);
}