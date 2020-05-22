ApiInterface apiService =
        RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

retrofit2.Call<BookResponce> call = apiService.getBooksById("zyTCAlFPjgYC", BOOKS_API_KEY);
call.enqueue(new Callback<BookResponce>() {
    @Override
    public void onResponse(retrofit2.Call<BookResponce> call, Response<BookResponce> response) {
        bookResp = response.body();
        for (int i = 0; i == 0; i++){
            bookList.add(i, bookResp.getBooks().get(i).getBookData());

            //This is what you must add
            bookList.get(i).setBookId(bookResp.getBooks().get(i).getId());
        }

        cAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(retrofit2.Call<BookResponce> call, Throwable t) {
        Toast.makeText(this, "failed", Toast.LENGTH_LONG).show();
    }
});