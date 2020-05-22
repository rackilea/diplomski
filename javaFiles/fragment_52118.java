@GET("books")
Call<ArrayList<Book>> listBooks();

@POST("books")
Call<Book> addBook(@Body Book book);

@GET("books/{id}/")
Call<Book> getBookInfo(@Path("id") int bookId);

@DELETE("books/{id}/")
Call<Void> deleteBook(@Path("id") int bookId);

@PUT("books/{id}/")
Call<Book> updateBook(@Path("id") int bookId, @Body Book book);

@DELETE("clean/")
Call<Void> deleteAll();