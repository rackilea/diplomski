boolean fahrenheitTemp = false;
public void actionPerformed(final ActionEvent e) {
    if (fahrenheitTemp) {
        updateTempF();
    } else {
        updateTempC();
    }
    final Double n = serial.x;
    series.addOrUpdate(new Millisecond(), n);
    Object source = e.getSource();
    if (source == buttonF) {
        degree.setText("degrees F");
        fahrenheitTemp = true;
        updateTempF();
    } else if (source == buttonC) {
        degree.setText("degrees C");
        fahrenheitTemp = false;
        updateTempC();
    }
}