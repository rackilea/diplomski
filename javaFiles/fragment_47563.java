private void initializeRecyclerView() {
    Log.d(TAG, "initializeRecyclerView: Initialize RecyclerView");
    RecyclerView intervalRecyclerView = findViewById(R.id.intervalRecyclerView);
    CustomAdapter adapter = new CustomAdapter(this, WTV, WET, RTV, RET, numberOfIntervals);
    intervalRecyclerView.setAdapter(adapter);
    intervalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
}