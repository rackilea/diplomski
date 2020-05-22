public void qgui() {
    {
        int pilih, enq = 0;
        inp = new Scanner(System.in);
        Queue theQueue = new Queue(5);
        try {
            while (theQueue.size() < 5) {
                System.out.println("1. Enqueue");
                System.out.println("2. Denqueue");
                System.out.print("Masukkan perintah (1/2): ");
                pilih = inp.nextInt();

                if (pilih == 1) {
                    System.out.print("Masukkan queue: ");
                    enq = inp.nextInt();
                    theQueue.enqueue(enq);
                    theQueue.Display(); // Once you add if you want to display you have to add this
                } else if (pilih == 2) {
                    while (!theQueue.isEmpty()) // In dequeue remove and display
                    { // all items
                        long n = theQueue.dequeue(); // (40, 50, 60, 70, 80)
                        System.out.print(n);
                        System.out.print(" ");
                    }
                }   
            }
        } catch (Exception e) {
            System.out.println("Data yang dimasukan bukan angka(Integer)!");
            System.out.println("Program harus di-restart!");
            System.exit(100);
        }
        while (!theQueue.isEmpty()) // NOTE - remove and display
        { // all items
            long n = theQueue.dequeue(); // (40, 50, 60, 70, 80)
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }
}