final Context themedContext = new ContextThemeWrapper(
        this.getContext(),
        android.R.style.Theme_Holo_Light_Dialog
);

final DatePickerDialog dialog = new FixedHoloDatePickerDialog(
        themedContext,
        datePickerListener,
        calender.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
);