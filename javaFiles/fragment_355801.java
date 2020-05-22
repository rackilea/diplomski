@Override
public IBinder onBind(Intent intent) {
    return new ISyncAndTradeService.Stub() {

        @Override
        public boolean startTradeEngine() throws RemoteException {
            return false;
        }
    };
}