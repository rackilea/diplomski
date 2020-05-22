@Override
protected void onDestroy() {
    super.onDestroy();
    unbindService(m_serviceConnection);
    Toast.makeText(MainActivity.this, "Service Un-Binded", Toast.LENGTH_LONG).show();
};