AlertDialog.Builder alert  = new AlertDialog.Builder(this);
alert.setView(R.id.Activity_AlertDialog_SetStartDate);
//  ... The rest of the AlertDialog, with buttons and all that stuff
AlertDialog dialog = alert.create();

dialog.show();
DatePicker datePicker = (DatePicker) dialog.findViewById(R.id.Activity_AlertDialog_SetStartDate);