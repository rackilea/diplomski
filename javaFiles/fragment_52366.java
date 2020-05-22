final String name = nameField.getText().toString();
final String quantityStr = quantityField.getText().toString();

if(TextUtils.isEmpty(name) || TextUtils.isEmpty(quantityStr))
{
     Toast.makeText(MainActivity.this, "Something went wrong. Check your input values", Toast.LENGTH_LONG).show();
}
else {
    final int quantity = Integer.parseInt(quantityStr);
    // TODO: here you can check if quantity <= 0 and handle that appropriately
    Product newProduct = new Product(name, quantity);
    mDatabase.addProduct(newProduct);

    //refresh the activity
    finish();
    startActivity(getIntent());
}