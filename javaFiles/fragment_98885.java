public void send()
    {
        synchronized(lock)
        {
            System.out.println("[Z] Send");
        }
        z.receive();
    }