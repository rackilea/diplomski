if(counterr>=5){
    counterr=0;
        json = jParser.makeHttpRequest(url_all_products, "GET", params);
        Intent i = new Intent(getApplicationContext(), AllProductsActivity.class);
        startActivity(i);
  }