double num = 1110;
    double ones = Math.floor(num % 10);
    double tens = Math.floor(num/10 % 10);
    double hundreds = Math.floor(num/100 % 10);
    double thousands = Math.floor(num %10000 /1000);
    double tenThousands = Math.floor(num / 10000 % 10);

    double original = (ones * 1) +
                      (tens * 2) + 
                      (hundreds * 4) +
                      (thousands * 8);


    System.out.println(num);
    System.out.println("ones: " +ones);
    System.out.println("tens: " +tens);
    System.out.println("hundreds: " +hundreds);
    System.out.println("thousands: " + thousands);
    System.out.println("original number : " + original);