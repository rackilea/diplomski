Random random = new Random();
for (int p = 0; p < b.length; p++) {
   b[p] = (int) (random.nextDouble() * 14 + 1);
   do {
      b[1] = (int) (random.nextDouble() * 14 + 1);
   } while (b[1] == b[0]);
...
}