class Test {
    public static void main(String[] args) {
        Server server = new Initiater();
        GuiImplementation gui = new Responder();

        //register gui as a listener for incoming/outgoing messages
        server.addListener(gui);

        //this will trigger the gui method to process incoming message
        server.sendMessage(); 
    }
}