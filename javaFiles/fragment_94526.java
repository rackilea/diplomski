private final static int HANDLER_FROM_HTTP = 1;
private final Handler mHandler = new Handler() {
    public void handleMessage(Message msg) {
        final int what = msg.what;
        switch(what) {
            case HANDLER_FROM_HTTP:  {
                Bundle b = msg.getDate();
                if (b != null) {
                    String s = b.getString("result");
                    doSomething(s);
                }
            }
        }
    }
};