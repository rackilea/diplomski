eventButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        //JUST FOR TESTİNG
            event = Example.getSharedInstance().eventsArrayList.get(0);
            Toast.makeText(getApplicationContext(),event.getDay() + ". day", Toast.LENGTH_SHORT).show();
        }
    });