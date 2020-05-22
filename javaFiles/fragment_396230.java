private TimePicker timePicker;

    timePicker = (TimePicker) dialog.findViewById(R.id.timePickerDialog);

    if(DateFormat.is24HourFormat(getActivity()){
        timePicker.setIs24HourView(true);
    }else {
        timePicker.setIs24HourView(false);
    }
    // here you can define your hour and minute value.
    timePicker.setCurrentHour(hour);
    timePicker.setCurrentMinute(minute);