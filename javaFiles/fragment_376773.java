//......... inside your jsonObjectRequest
//rename item_1 and item_2 
String myItem_1 = respons.getString("item_1");
String myItem_2 = respons.getString("item_2");
Prices.this.runOnUiThread(new Runnable() {
    public void run() {
        item_1.setText(myItem_1);
        item_2.setText(myItem_2);
    }
});