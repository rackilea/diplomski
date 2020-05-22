Client client1 = new Client("192.168.1.100", 8888);
    Client client2 = new Client("192.168.1.101", 8888);
    Client client3 = new Client("192.168.1.102", 8888);

    client1.start();
    client2.start();
    client3.start();

    try {
        client1.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    try {
        client2.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    try {
        client3.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }