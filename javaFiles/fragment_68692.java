yourRecyclerView.setAdapter(new YourAdapter(..., ..., new OnMyCheckBoxCheckedChangeListener() {
    @Override
    public void onMyCheckBoxCheckedChange() {
        // you will get notified here.
    }
}));