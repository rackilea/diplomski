Call<DataResponse> call = apiInterface.getUsers(page_num, per_page);

call.enqueue(new Callback<DataResponse>() {
    @Override
    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
        Toast.makeText(MainActivity.this, "Response success....", Toast.LENGTH_SHORT).show();
        List<Data> data = response.body().getData();
        adapter = new RecyclerAdapter(data, MainActivity.this);
        recyclerView.setAdapter(adapter);
        Toast.makeText(MainActivity.this, "First page is loaded...", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(Call<DataResponse> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Bad request", Toast.LENGTH_SHORT).show();
    }
});