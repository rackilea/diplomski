public View getView(int position, View convertView, ViewGroup parent) {

    View v = convertView;
    ViewHolder holder;

    if (v == null) {
        LayoutInflater vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.alarm_item, null);
        holder = new ViewHolder();
        holder.alarmView = (TextView) v.findViewById(R.id.alarmNameTV);
        holder.alarmDateTimeView = (TextView) v.findViewById(R.id.alarmDateTime);
        v.setTag(holder);
    } else {
        holder = (ViewHolder) v.getTag();


        }   
   final PAlarm alarm  = alarms.get(position);
   if (alarm != null) {
       holder.alarmView.setText(alarm.get_eventName());
       holder.alarmDateTimeView.setText(alarm.get_eventDate() + " (" + alarm.get_eventTime() + ")" );
    }

    return v;

}