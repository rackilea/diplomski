DatePickerDialog datePickerDialog = new DatePickerDialog(RoomFragment.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    monthOfYear = monthOfYear+1;
                    btn1.setText(monthOfYear+"/"+dayOfMonth+"/"+year);
                }
            }, year, month, day);