private class OnClickListenerWithAdresa {
    private String mAdresa;
    public OnClickListenerWithAdresa(String adresa) {
        this.mAdresa = adresa;
    }
    public void onClick(View v) {
        // Perform action on click   
        Intent activityChangeIntent = new Intent(DatabasesActivity.this, PrikazMape.class);
        activityChangeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activityChangeIntent.putExtra("add", mAdresa); // NOTE use the listener's private field
        DatabasesActivity.this.startActivity(activityChangeIntent);
    }
}