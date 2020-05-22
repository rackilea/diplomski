public static void main(String args[]) {
    final evensoft f = new evensoft();

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            f.setVisible(true);
        }
    });

    // ...

    while(true) {
        try {
            clientsocket=serversocket.accept();
            reader=new InputStreamReader(clientsocket.getInputStream());  
            breader=new BufferedReader(reader);
            message=breader.readLine();
            final char a[]=message.toCharArray();

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    f.formatmessage(a);
                }
            });
        }
        // ...
    }
}