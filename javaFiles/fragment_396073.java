EventsStructure eventStructure = new EventsStructure();
eventStructure.onServerErrorEvent = new ServerErrorEvent() //implement server error event
{
    @Override
    public void invoke(long serverConnectionHandlerID, String errorMessage, int error, String returnCode, String extraMessage)
    {
        System.out.println("server error");
    }
};
ts3client_initClientLib(eventStructure, null, 0, "logs", "soundbackends"); //invoke ts3client_initClientLib function from library