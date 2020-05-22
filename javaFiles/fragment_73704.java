cView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                yourActivity.this.day = day;
                yourActivity.this.month = month;
                yourActivity.this.year = year;
            }
        });