@Override
public void onClick(View v) {

    NumberPicker numPicker = (NumberPicker)findViewById(R.id.NumberPicker_id);
    int x = numPicker.getValue();
    Intent intent = new Intent(this, Destination.class);
    intent.putExtra("VarName", x);
    startActivity(intent);
}