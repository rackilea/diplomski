private class AlarmListAdapter extends ArrayAdapter<UserInputAlarmData> {
    public AlarmListAdapter() {
        super(getActivity(),
              R.layout.alarm_view_item,
              R.id.TitleName, // Passing TextView id
              UserInputAlarmData);
    }
}