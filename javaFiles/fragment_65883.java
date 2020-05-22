TreeSet<Double> groups = new TreeSet<>();
groups.add( 5d);                      // [-Inf,    5]
groups.add(10d);                      // ]   5,   10]
groups.add(15d);                      // ]  10,   15]
groups.add(20d);                      // ]  15,   20]
groups.add(25d);                      // ]  20,   25]
groups.add(30d);                      // ]  25,   30]
groups.add(Double.POSITIVE_INFINITY); // ]  30, +Inf]

Random rnd = new Random();
for (double value = 0d; value <= 30d; value += 5d) {
    double down = Math.nextDown(value);
    double up = Math.nextUp(value);
    System.out.printf("%-18s -> %4s     %-4s -> %4s     %-18s -> %4s%n",
                      down, groups.ceiling(down),
                      value, groups.ceiling(value),
                      up, groups.ceiling(up));
}
for (int i = 0; i < 10; i++) {
    double value = rnd.nextDouble() * 30d;
    double group = groups.ceiling(value);
    System.out.printf("%-18s -> %4s%n", value, group);
}