int sum = 0; // scope is *outside* of do-while loop
do {
  int a = (int) (Math.random() * 13);
  int b = (int) (Math.random() * 13);
  int c = (int) (Math.random() * 13);
  int d = (int) (Math.random() * 13);
  sum = a + b + c + d;
} while (sum != 24);