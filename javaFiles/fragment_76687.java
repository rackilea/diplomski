Thread t = new Thread(new ClientThread());
        t.start();

...//when you've to send the String

t.inviaStringa(view, ordine);