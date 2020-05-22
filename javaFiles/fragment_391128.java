String line = "line";
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    do {
        logger.info("You typed: " + line + ". Please type 'exit' to terminate the program!");
        line = in.readLine();
    } while (!line.equals("exit"));
    logger.info("You typed: " + line + ". Please wait until the application is successfully shutdown...");

    f.addListener(new ChannelFutureListener() {
        public void operationComplete(ChannelFuture future) throws Exception {
            myChannelPipeline.getMyClientHandler().sendDisconnectRequest(future);
        }
    });