public class SendTextToServerAction extends ActionImpl<SendTextToServerResult> {
    private String textToServer;

    public SendTextToServerAction(final String textToServer) {
        this.textToServer = textToServer;
    }
    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private SendTextToServerAction() {
    }

    public String getTextToServer() {
        return textToServer;
    }

    @Override
    public boolean isSecured() {
        return false;
    }