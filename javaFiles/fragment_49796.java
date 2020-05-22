final String [] fruits = getResources().getStringArray(R.array.fruits_array);
builder.setItems(R.array.fruits_array, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        pickFruitButton.setText(fruits[which]);
        dialog.dismiss();
    }
});