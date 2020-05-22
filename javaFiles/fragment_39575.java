int n = 1_000_000;
int count = 0;
Random rnd = new Random();

boolean matched_last_time = false;
for (int i = 0; i < n; i++) {
    int a = rnd.nextInt(6);
    int b = rnd.nextInt(6);
    boolean match = a == b;

    if (match && matched_last_time) {
        count++;
        // match = false;  // Uncomment this line, & probability changes to 1 in 42
    }
    matched_last_time = match;
}

System.out.println(count + " / " + n);
System.out.println("Or about 1 in " + (n * 1.0 / count));