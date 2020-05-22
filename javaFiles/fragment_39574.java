int n = 1_000_000;
int count = 0;
Random rnd = new Random();

for (int i = 0; i < n; i++) {
    int a = rnd.nextInt(6);
    int b = rnd.nextInt(6);
    int c = rnd.nextInt(6);
    int d = rnd.nextInt(6);

    if (a == b && c == d) {
        count++;
    }
}

System.out.println(count + " / " + n);
System.out.println("Or about 1 in " + (n * 1.0 / count));