@Override
public void handleMessage(Message msg) {
    super.handleMessage(msg);
    MainActivity main = wMain.get();

    // message arrived after activity death
    if (main == null) return;

    int what = msg.what;
    if(what == MSG_PULLED) {
        main.startAnim();
    } 
}