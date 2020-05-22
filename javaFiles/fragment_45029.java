InvoiceRecyclerViewAdapter adapter = new InvoiceRecyclerViewAdapter(
        this ,cart_productslist, new InvoiceRecyclerViewAdapter.OnQuantityChangeListener(){

    @Override
    void onQuantityChange( float difference ){

        total += difference;
        total_textview.setText("Rs "+ total);

    }

} );