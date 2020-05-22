@Override
public void actionPerformed(final ActionEvent e) {
    double celsius = 0, fahrenheit = 0;
    DecimalFormat twoDigits = new DecimalFormat("0.00");
    if (Temperature_Converter.this.TFCelsius.getText() == null || "".equals(Temperature_Converter.this.TFCelsius.getText().trim())) {
        // convert from fahrenheit to celsius
        fahrenheit = Double.parseDouble(Temperature_Converter.this.TFFahrenheit.getText());
        celsius = (fahrenheit - Temperature_Converter.offset) *   Temperature_Converter.FahrenheitTOCelsius;
        Temperature_Converter.this.TFCelsius.setText(" " + twoDigits.format(celsius));
    } else if (Temperature_Converter.this.TFFahrenheit.getText() == null || "".equals(Temperature_Converter.this.TFFahrenheit.getText().trim())) {
           // convert from celsius to fahrenheit
           celsius = Double.parseDouble(Temperature_Converter.this.TFCelsius.getText());
           fahrenheit = celsius * Temperature_Converter.CelsiusTOFarenheit + Temperature_Converter.offset;
           Temperature_Converter.this.TFFahrenheit.setText(" " + twoDigits.format(fahrenheit));
    }
}