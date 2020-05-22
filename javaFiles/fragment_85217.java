public void actionPerformed(ActionEvent e) {
    // if timer starts then set new time
    if (e.getSource().equals(timer)) {
        // set new time
        String currentTime = sdf.format(new Date(System.currentTimeMillis()));
        timeLabel.setText(currentTime);
        alarm(currentTime, alarmHour);  // Check if alarm should trigger
    }
}