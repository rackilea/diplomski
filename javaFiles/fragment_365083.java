Date pickerDate = new Date(date.getYear(), date.getMonth(), date.getDayOfMonth());
   if (pickerDate.before(currentDate)) {
       Toast.makeText(getApplicationContext(), "The date is too old", Toast.LENGTH_LONG);
   } else {
       Intent i = new Intent(UserMenu.this, UserMenuTime.class);
       i.putExtra("date", dateFormat);
       startActivity(i);
   }