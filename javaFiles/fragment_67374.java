private void showPopUp3() {
AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
helpBuilder.setTitle("Enter your string");

LayoutInflater inflater = getLayoutInflater();
View checkboxLayout =inflater.inflate(R.layout.popuplayout, null);
getInput = (EditText)  checkboxLayout.findViewById(R.id.editText1);
getInput.setText(YOUR_STRING);
helpBuilder.setView(checkboxLayout);

helpBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {


    public void onClick(DialogInterface dialog, int which) {
        // THIS IS SUPPOSED TO STORE THE VALUE OF THE EDIT-TEXT AND OUTPUT IT IN THE TEXTVIEW

        showPopUpButton.setText(getInput.getText());//NEW**
        }
    });

AlertDialog helpDialog = helpBuilder.create();
helpDialog.show();
}