tz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            SimpleDateFormat df = new SimpleDateFormat("dd MMM HH:mm a", Locale.getDefault());
            df.setTimeZone(TimeZone.getTimeZone(idAdapter.getItem(position))); //format in given timezone
            String strDate = df.format((new Date()).getTime());
            //Display the Toast
            Toast.makeText(getApplicationContext(), strDate, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            // your code here
        }

    });