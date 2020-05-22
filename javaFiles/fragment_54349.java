int v = 0;
long cnt = 0;
for (int i = 0; i < s.length(); ++i) {
  int w = Character.digit(s.charAt(i), 10);
  if ((v * 10 + w) % 4 == 0) {
    cnt += i;
  }
  if (w % 4 == 0) {
    ++cnt;
  }
  v = w;
}