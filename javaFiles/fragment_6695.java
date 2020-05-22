final Thread outThread = new Thread() {
    @Override
    public void run() {
        System.out.println("Started...");
        PrintWriter out = null;
        Scanner sysIn = new Scanner(System.in);
        try {
            out = new PrintWriter(socket.getOutputStream());
            out.println(name);
            out.flush();

            while (sysIn.hasNext() && !isFinished.get()) {
                String line = sysIn.nextLine();
                if ("exit".equals(line)) {
                    synchronized (isFinished) {
                        isFinished.set(true);
                    }
                }
                out.println(line);
                out.flush();
                disconnect();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    };
};
outThread.start();