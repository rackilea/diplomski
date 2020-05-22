Retrofit.Builder builder = new Retrofit.Builder()
        .baseUrl("http://192.168.1.6:8080/")
        .addConverterFactory(GsonConverterFactory.create());

Retrofit retrofit = builder.build();
DriverClient driver = retrofit.create(DriverClient.class);
Call<Driver> call = driver.getDriverName();

call.enqueue(new Callback<Driver>() {
    @Override
    public void onResponse(Call<Driver> call, Response<Driver> response) {
        Driver driver = response.body();

        Toast.makeText(MainActivity.this, "Size : " + list.size(), Toast.LENGTH_SHORT).show();

        String name = driver.getName();
        Toast.makeText(MainActivity.this, "Name : " + name , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<Driver> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
    }
});