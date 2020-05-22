class Applet {
    public static void main(String[] args) {
        new Applet(); // Initialize application.
    }

    Applet() {
        while (true) {
            readMessage();
            // ... and save the state for later processing if needed

            // Send the reply:
            sendMessage("{\"data\": \"somee data\"}");
        }
    }

    // TODO: Implement readMessage and sendMessage (see question).
}