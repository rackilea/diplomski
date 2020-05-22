private final BroadcastReceiver m_timeChangedReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        Calendar hCal = Calendar.getInstance();
        int hHour = hCal.get(Calendar.HOUR);
        ArchProgressBar bar = (ArchProgressBar) findViewById(R.id.arch_progress_bar);
        if (bar != null) {
            bar.drawMeCircle(1);
        }
    }
};

// remember to unregister the broadcast receiver in your onDestroy()
// as further optimization, you can also move the findViewById inside your onCreate(), so you don't have to repeat it for every broadcast you get