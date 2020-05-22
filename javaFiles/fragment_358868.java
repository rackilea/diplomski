BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Here you check the timer is running or not
              timer.cancel();
}
    };