static int d = 0;
@Override
public void onReceive(Context context, Intent intent) {
    String intentAction = intent.getAction();
    if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
    return;
    }
    KeyEvent event = (KeyEvent) intent
        .getParcelableExtra(Intent.EXTRA_KEY_EVENT);
    if (event == null) {
    return;
    }
    int action = event.getAction();
    switch (event.getKeyCode()) {
    case KeyEvent.KEYCODE_HEADSETHOOK:
        if (action == KeyEvent.ACTION_DOWN) {
            d++;
            Handler handler = new Handler();
            Runnable r = new Runnable() {

            @Override
            public void run() {
                    // single click *******************************
                    if (d == 1) {
                                Toast.makeText(context, "single click!", Toast.LENGTH_SHORT).show();
                    }
                    // double click *********************************
                    if (d == 2) {
                        Toast.makeText(context, "Double click!!", Toast.LENGTH_SHORT).show();
                    }
                    d = 0;
            }
            };
            if (d == 1) {
                    handler.postDelayed(r, 500);
            }
        }break;
   }
   abortBroadcast();
}