serialPort.addEventListener((SerialPortEvent serialPortEvent) -> {
    try {
        System.out.println("Your selected text for label : " + objectname);
        objectname = "Nothing";
        Platform.runLater(() -> {
            label2.setText(objectname);
        });
        System.out.println("Label gettext : " + label2.getText());
    } catch (Exception e) {
        e.printStackTrace();
    }
}