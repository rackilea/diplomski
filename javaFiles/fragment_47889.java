System.out.println("Wrong."); // Displays "Wrong." no matter the answer.
    try // Looks like you missed the try here
    {
        Thread.sleep(2000); // Adds a timer for 2 seconds.
    } catch (InterruptedException e) {
        System.out.println("Please, try again :-)");
    }