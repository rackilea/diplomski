public void onClick(View v) {
   //FIND LOCATION BY ADDRESS

   if (searchaddress.getText().toString() != null && !searchaddress.getText().toString().isEmpty()) {

          GetAddressPositionTask addressTask = new GetAddressPositionTask(map, position);
          addressTask.execute(searchaddress.getText().toString());

  } else {
          Toast.makeText(getApplicationContext(), "Please enter an address!", Toast.LENGTH_LONG).show();
  }
}