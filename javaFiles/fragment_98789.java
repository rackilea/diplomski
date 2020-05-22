MainActivity.this.runOnUiThread(new Runnable() {
    public void run() {
        m_myLastItem = HistoryAdapt.getLastElement();
        //set last signal into TextView
        mSignal.setText(m_myLastItem.getTitle());
    }
});