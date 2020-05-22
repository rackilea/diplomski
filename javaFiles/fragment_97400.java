View dialogView = LayoutInflater.from(this).inflate(R.layout.activity_alertdialog_date, false);
DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.Activity_AlertDialog_SetStartDate);

AlertDialog.Builder alert  = new AlertDialog.Builder(this);
alert.setView(dialogView);
//  ... The rest of the AlertDialog, with buttons and all that stuff
alert.create().show();