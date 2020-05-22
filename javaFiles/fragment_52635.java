interface ApiInterface{
    @GET("api/v1/customers")
    Call<CustomersResponse> getCustomers();

    @GET("api/v1/products")
    Call<ProductsResponse> getProducts();
}