ServerSocket socketListener = new ServerSocket(port);
Task task = new Task();
new Thread(task).start();

while (true) {
            Socket client = socketListener.accept();
            task.executeCommand(userCommand);
        }