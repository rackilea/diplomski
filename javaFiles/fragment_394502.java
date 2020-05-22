public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    delivery.setText(getCost(position));
//    totalCost += Double.valueOf(delivery.getText().toString());  change here
    totalCost = productPrice + Double.valueOf(delivery.getText().toString()); 
    total.setText(Double.toString(totalCost));
}
@Override
public void onNothingSelected(AdapterView<?> parent) {
    delivery.setText("0.00");
    totalCost -= Double.valueOf(delivery.getText().toString());
    total.setText(Double.toString(totalCost));

}