Random r = new Random();
int a = r.nextInt(10);
int b = r.nextInt(9);

while(a==b)
      b = r.nextInt(9);