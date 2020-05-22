private void configViews(ArrayList<Issue> issueArrayList) {
    recyclerView = findViewById(R.id.recyclerview);
    issueAdapter2 = new IssueAdapter2(issueArrayList);
    recyclerView.setHasFixedSize(true);
    recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(issueAdapter2);
        }
    );
}