ListView l = (ListView) CartPage.this.findViewById(R.id.cartItems);
EditText editText=(EditText) view.findViewById(R.id.product_count);
String string;
// total_item_count is equal to the int 11, which is how many cells there are.
for(int i=0;i<total_item_count-1;i++){
    View view=l.getChildAt(i);
    System.out.println("("+i+"/"+total_item_count+")");

    string=editText.getText().toString();
    System.out.println(i+": "+string);

}