private String getCustomAddress() {
    final EditText addressEditText = new EditText(this);
    final String[] customAddress = {""};

    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
    alertDialog.setTitle("Please enter destination address");
    alertDialog.setView(addressEditText);
    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int whichButton){
            customAddress[0] =  addressEditText.getText().toString();
            //add call to ggtransporttype here********
            doNext();//or you can use a handler here!!
    });
    alertDialog.setNegativeButton("CANCEL", null);
    alertDialog.create().show();

    return customAddress[0];
}


 private void doNext(){
       //3. Find out what transportation method user wants
        GetTransportType(googTransitButton, googBikeButton, googDrivingButton, googWalkingButton);

        //4. Get directions from Google Maps
        getGoogleDirections(mode);

  }