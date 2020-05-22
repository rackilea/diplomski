alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                 String newText = input.getText().toString();
                 textView.setText(newText);
            }
});