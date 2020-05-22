int n = 3; // your "n"

// Build a list of numbers
List<Integer> l = new ArrayList<>();
for (int x = 1; x <= n; x++) {
     l.add(x);
}

int t = 17; // add 17 more random numbers in range 1-3 inclusive

for (int i = 0; i < t; i++) {
    l.add(rnd.nextInt(n) + 1);
}

// Shuffle
Collections.shuffle(l);

// Print
for (Integer value : l) {
    System.out.println(value);
}