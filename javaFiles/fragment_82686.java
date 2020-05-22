//example String monkey_options = "--ignore-crashes --throttle 500 -v 500"; 
    try {
        Process monkey_process = new ProcessBuilder().command("monkey", monkey_options).start();
        monkey_process.waitFor();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }