int n = 2; // your "n"
int t = 100; // how often you want each number x to occur, where 0 <= x < n

// Build a list of numbers
List<Integer> l = new ArrayList<>();
for (int i = 0; i < t; i++) {
    for (int j = 0; j < n; j++) {
        l.add(j);
    }
}
// Shuffle the list randomly; this ensures the order is random but each number x occurs
// as often as any other x
Collections.shuffle(l);

for (Integer value : l) {
    System.out.println(value);
}