List<TimeSolt> slots ;
    //assign the data from network or local...

    //create gridview from xml ...

    gridView.setColumnCount(3);

    //other properties goes here..

    //create custom adapter

    adapter = new CustomAdapter(this, slots);

    //other properties like onitemclick....



gridView.setAdapter(adapter);

            //create gridview from xml ...
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
        //change the data of slots  according to date 
    //slots = newData; and call 
    adapter.notifyDataSetChanged();

                    }
                });