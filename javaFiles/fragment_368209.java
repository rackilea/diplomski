public class SetupMessageSender implements Runnable{


    private SetupMessageListener setupMessageListener;

    public SetupMessageSender(SetupMessageListener setupMessageListener){
        this.setupMessageListener = setupMessageListener;
    }

    @Override
    public void run() {
        if (setupMessageListener != null) {
            setupMessageListener.onNewSetupMessage();
        }
    }

    public SetupMessageListener getSetupMessageListener() {
        return this.setupMessageListener;
    }

    public void setSetupMessageListener(SetupMessageListener setupMessageListener) {
        this.setupMessageListener = setupMessageListener;
    }
}