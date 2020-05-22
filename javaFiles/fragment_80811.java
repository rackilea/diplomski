public class IncomingReceiver extends BroadcastReceiver {
    private MainActivity act;
    public IncomingReceiver(MainActivity main){
        this.act = act;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(CUSTOM_INTENT)) {
            System.out.println("GOT THE INTENT");
            // call the method on act
        }
    }
}