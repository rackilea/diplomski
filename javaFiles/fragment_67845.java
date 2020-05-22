long a = 2147483647;
long b = 2147483647;
long mult = a * b;

System.out.println((int) mult);     // 1
System.out.println(mult);           // 4611686014132420609
System.out.println((double) mult);  // 4.6116860141324206E18