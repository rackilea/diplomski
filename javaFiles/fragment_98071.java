Random r = new Random();
int count = 0;
for (int i = 0; i < 1000_000; i++)
    if (r.nextInt(6000) < 100)
        count++;
System.out.println(count);