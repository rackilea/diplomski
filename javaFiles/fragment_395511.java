abstract class ConversionListener implement ActionListener {
    DecimalFormat formatter = new DecimalFormat("#,###,###.##");

    public void actionPerformed(ActionEvent e) {
        String input = temp.getText();
        if (input.equals("")) {
           input = "0";
           temp.setText(input);
        }
        double number = Double.parseDouble(input);
        results.setText(formatter.format(convert(number)));
    }
    /** to implement by subclasses */
    abstract double convert(double number);
}
celsiusToFahrenheit.addActionListener(new ConversionListener() {
    double convert(double celsius) {
        return number * 9 / 5 + 32;
    }
});
fahrenheitToCelsius.addActionListener(new ConversionListener() {
    double convert(double fahrenheit) {
        return (fahrenheit - 32) / 9 * 5;
    }
});