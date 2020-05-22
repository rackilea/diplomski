private final Runnable refresh_input = new Runnable() {

@Override
public void run() {
    bt_read_input = GlobalVar.bt_input;
    }
    refresh_handler.postDelayed(refresh_input, 250);
}