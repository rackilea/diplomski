btn.setOnClickListener(bew View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Pass a Context as SettingsActivity from anonymous listener. Note if it's not an inner class you can just pass "this"
        IPandPort.setIp(SettingsActivity.this);
    }
});