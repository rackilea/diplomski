public class Connection implements Runnable {

    IUpdater updater;
    Connection(IUpdater u){updater = u;}

    @Override
    public void run() {
        String command = "download_file"; //=getCommand(); from a socket
        if(command.equals("download_file")) {

            AskUser ask = new AskUser();
            ask.command = command;
            ask.updater = updater;
            SwingUtilities.invokeLater(ask);
            try {
                ask.userInput.await();
            } catch (Exception e) {
                // waiting for user input was interrupted
            }
            System.out.println("Result: " + ask.result);
        }
    }
}