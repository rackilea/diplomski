@Override
public void onReceive(Context context, Intent intent) {
        Bundle data = intent.getExtras();
        Customer customer = (Customer) data.getSerializable("customer");
    }
}