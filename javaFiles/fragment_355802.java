private ISyncAndTradeService syncAndTradeService;
private boolean hasBounded = false;

private Intent syncAndTradeServiceIntent;

private ServiceConnection syncAndTradeServiceConnection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        syncAndTradeService = ISyncAndTradeService.Stub.asInterface((IBinder) service);
        hasBounded = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        syncAndTradeService = null;
        hasBounded = false;
    }
};