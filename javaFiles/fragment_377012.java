List<String> list = Arrays.asList("x 0", "a 0", "b 0", "c 1", "x 0", "d 0", "e 0", "f 0", "g 0",
                                  "h 0", "i 0", "j 0", "k 0", "l 0", "m 0", "n 0", "o 0", "p 0");
// code from above here
System.out.printf("list : %2d %s%n", list.size(), list);
System.out.printf("part1: %2d (%4.1f%%) %s%n", part1.size(), part1.size() * 100d / list.size(), part1);
System.out.printf("part2: %2d (%4.1f%%) %s%n", part2.size(), part2.size() * 100d / list.size(), part2);