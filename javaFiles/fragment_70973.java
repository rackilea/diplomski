Main main = new Main();
main.integer = new AtomicInteger(3);  // Reference to a mutable object

integers.add(main.integer);           // Add reference to list

main.integer.set(4);                  // Change mutable object

System.out.println(integers.get(0));  // Prints 4