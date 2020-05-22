protected void channelRead0(ChannelHandlerContext ctx, Command cmd) throws Exception {

    blockingIOProcessor.execute(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting.");

            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Finished.");
        }
    });

}