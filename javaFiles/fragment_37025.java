char[] T = "hhllyyjhhh".toCharArray();
String ans = "";
for (int i = 0; i < T.length; i++) {
  int count = 1;
  while (i + count < T.length && T[i + count] == T[i]) {
    count++;
  }
  ans += T[i] + String.valueOf(count);
  i += count - 1;
}
System.out.println(ans);