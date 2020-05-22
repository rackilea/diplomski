n = 0;
    total = 0;
    total_squared = 0;

    while ( num != -1 ) {

        n++;
        total += num;
        total_squared += num*num;
        System.out.print("Next Number: ");
        num = input.nextDouble();
    }