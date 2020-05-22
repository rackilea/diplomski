// This is how to print with a delay
    // Thread.sleep stops the program executoin for an amount of time
    System.out.println("String 1");


    try {
        Thread.sleep(1000);  // Thread.sleep takes in milliseconds
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println("String 2");

    // This is how to count down with a delay. Its accuracy is questionable, because
    // printing and increminting k take time, but it should be very close to a second.
    for(int k = 10; k > 0; k--)
    {
        System.out.println(k);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }