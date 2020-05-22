private class RemoteControlServer extends RemoteControl
{

    ...

    public class BridgeThread implements Runnable
    {
        String[] msgArray = null;
        public BridgeThread(String[] msg)
        {
            msgArray = msg;
        }

        public void run()
        {
            runOnUiThread(new Runnable()
            {   
                @Override
                public void run()
                {
                    TextView zValue = (TextView) findViewById(R.id.connectionStatus);
                    zValue.setText(msgArray[0]);
                }
            });
        }
    }

    @Override
    public void onReceive(String[] msg)
    {
        BridgeThread bridgeTest = new BridgeThread(msg);
        bridgeTest.run();
    }

    ...
}