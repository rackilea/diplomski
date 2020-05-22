Random rnd = new Random();
int number;

// print out 1 as you need it to be the first number
System.out.println(1);

// observe here that we start i at 2
for (int i = 2; i <= 100; i++) {
    if (i % 7 == 0) {
        System.out.println(i + " : Lucky number!");
    }

    if (i % 5 == 0) {
        // Do something else here...
    }
    number = rnd.nextInt(100);
    System.out.println(number);
}