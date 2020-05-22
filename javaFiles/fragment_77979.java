public void Calc(View v) {
    int itemA, itemB;
    itemA = a.getSelectedItemPosition();
    itemB = b.getSelectedItemPosition();
    int e = itemA * 10 + itemB;
    Toast.makeText(this, "Value: " + e, Toast.LENGTH_LONG).show();
}