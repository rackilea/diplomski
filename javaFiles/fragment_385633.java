public void ButtonClick()
{

    AlertDialog.Builder dialog=new AlertDialog.Builder(this);
    LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View pickers=layoutInflater.inflate(R.layout.time_picker,null);
    final TimePicker time = (TimePicker)pickers.findViewById(R.id.time_picker);
    final CheckBox repeat_daily = (CheckBox) pickers.findViewById(R.id.repeat_daily);
    dialog.setView(pickers);
    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface dialog, int which)
        {
            time.clearFocus();
            int hour = time.getCurrentHour();
            int minute = time.getCurrentMinute();

            Notification.getTime(hour, minute, repeat_daily.isChecked());
            Notification.scheduleNotification(AgendaActivity.this, 1);
        }
    });
    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
    {
        @Override
        public void onClick(DialogInterface dialog, int which)
        {
            dialog.dismiss();
        }
    });

    AlertDialog alertDialog=dialog.create();
    alertDialog.show();

}