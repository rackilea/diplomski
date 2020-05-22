public class GuiUpdater extends SwingWorker<Boolean, String> {
    private String command;

    public GuiUpdater(String inputCommand) {
        super();
        command = inputCommand;
    }

    public void publish(String chunk) {
        super.publish(chunk);
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        Output.setWorker(this);
        boolean successfulCommand = game.performCommand(command);
        return successfulCommand;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String chunk : chunks) {
            textOutput.append(chunk);
        }
    }

    @Override
    protected void done() {
        boolean successfulCommand;
        try {
            successfulCommand = get();
        } catch (InterruptedException | ExecutionException e) {
            successfulCommand = false;
        }
        if (!successfulCommand) {
            textOutput.append("Invalid command.\n");
        }
        inputField.setText("");
    }
}

@Override
public void actionPerformed(ActionEvent event) {
    if (game.isItYourTurn()) {
        inputCommand = inputField.getText();
        if (inputCommand.length() != 0) {
            GuiUpdater worker = new GuiUpdater(inputCommand);
            worker.execute();
        }
    } else {
        textOutput.append("\nWait for your turn!\n");
    }
}