int ones = 0;
int zeros = 0;
for (int index = 0; index < 100; index++) {

    double rand = Math.random() * 1;
    if (Math.round(rand) == 1) {
        ones++;
    } else {
        zeros++;
    }
    System.out.println(rand + " - " + (int)Math.round(rand) + " - " + (int)Math.random() * 1);

}

System.out.println("Ones = " + ((float)ones / 100f));
System.out.println("Zeros = " + ((float)zeros / 100f));