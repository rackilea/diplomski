final String in = "ABBCDDDEFGGH" + '\u0000';
final StringBuilder b = new StringBuilder();
char prev = in.charAt(0);
int rpt = 0;
for (int i = 1; i < in.length(); i++) {
  final char curr = in.charAt(i);
  if (curr == prev) rpt++;
  else {
    b.append(rpt == 0? prev : "" + (rpt + 1) + prev);
    rpt = 0; prev = curr;
  }
}
System.out.println(b);