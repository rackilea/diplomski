private void saveItemCheck() {
    String nameString = mNameEditText.getText().toString().trim();
    String priceString = mPriceEditText.getText().toString().trim();
    String quantityString = mQuantityEditText.getText().toString().trim();
    String supplierString = mSupplierEditText.getText().toString().trim();
    String supplierNumberString = mSupplierNumberEditText.getText().toString().trim();

    if (mCurrentInventoryUri == null &&
            TextUtils.isEmpty(nameString) && TextUtils.isEmpty(priceString) &&
            TextUtils.isEmpty(quantityString) && TextUtils.isEmpty(supplierString) &&
            TextUtils.isEmpty(supplierNumberString)) {
        return;
    }
    if (TextUtils.isEmpty(nameString) || TextUtils.isEmpty(priceString)
            || TextUtils.isEmpty(quantityString) || TextUtils.isEmpty(supplierString)
            || TextUtils.isEmpty(supplierNumberString)) {
        Toast.makeText(this, "Please fill all the starred fields to save the product",
                Toast.LENGTH_LONG).show();
    } else {
        Float price = Float.parseFloat(priceString);
        int quantity = Integer.parseInt(quantityString);
        saveItem(nameString, price, quantity, supplierString, supplierNumberString);
    }
}