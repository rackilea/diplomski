private Calendar startTime, endTime;
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String dataFromActivity2 = data.getStringExtra("fav");
            // create event here
            WeekViewEvent event = new WeekViewEvent();
            event.setId(7);
            event.setName(dataFromActivity2);
            event.setStartTime(startTime);
            event.setEndTime(endTime);
            event.setColor(getResources().getColor(R.color.event_color_03));

            Log.d(TAG, "Intent test:" + dataFromActivity2);
            mNewEvents.add(event);
            mWeekView.notifyDatasetChanged();
    }