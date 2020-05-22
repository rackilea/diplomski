public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("PollThread");
    myTimer = new Timer();
    final ClientThread cThread = new ClientThread(ip);
    myTimer.schedule(new TimerTask() {
        @Override
        public void run() {
            String status = cThread.readStatus();
            System.out.println("Staus :: "+status);
        }
    }, 0, 2000);
}