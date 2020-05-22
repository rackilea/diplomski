if (on_off_switch.isChecked()) {
    command = "1";
    try {
        outputStream.write(command.getBytes()); //transmits the value of command to the bluetooth module
    } catch (IOException e) {
        e.printStackTrace();
    }
} else {
    command = "10";
    try {
        outputStream.write(command.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}