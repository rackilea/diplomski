private void read(String command){
    [...]
    // Write to Process
    if (outStream != null) {
        [...]
        try {
            writer.write(command + "\n");  // add newline so your input will get proceed
            writer.flush();  // flush your input to your process
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    // ELSE!! - if no outputstream is available
    // Execute Command
    else {
        try {
            exec(command);
        } catch (IOException e) {
            // Handle the exception here. Mostly this means
            // that the command could not get executed
            // because command was not found.
            println("Command not found: " + command);
        }
    }
    inPane.setText("");
}