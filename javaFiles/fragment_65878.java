mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName arg0, IBinder arg1) {
                mService = IInAppBillingService.Stub.asInterface(arg1);
                try {
                    bundle = mService.getBuyIntent(3, getActivity().getPackageName(), "pro_version", "inapp", "bGoa+V7g/yqDXvKRqq+JTFn4uQZbPiQJo4pf9RzJ");
                    pending = bundle.getParcelable("BUY_INTENT");
                    getActivity().startIntentSenderForResult(pending.getIntentSender(), 1001, new Intent(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SendIntentException e) {
                     // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName arg0) {
                // TODO Auto-generated method stub
                mService = null;
            }
        };