// AlarmType alarm = new AlarmType();
while (rs.next()) {
    AlarmType alarm = new AlarmType(); // create new instance here
    alarm.setDeviceIndex(rs.getInt(1));
    /* ... */
    alarm.setAlarmTime(rs.getTimestamp(8));
    // alarmsTableView.getItems().add(alarm); // this shouldn't be necessary
    data.add(alarm);
    System.out.println(alarm.toString());
}
alarmsTableView.setItems(data);