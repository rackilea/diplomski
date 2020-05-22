// Create and add convert button
    JButton fahrenheitButton = new JButton("Convert");
    fahrenheitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            // Check if input is of type double and perform action
            if (isNumber(tempTextField.getText())) {
                double  inputTemp = Double.parseDouble(tempTextField.getText());

                int tempKelvin = -1;
                int tempCelcius = -1;
                int tempFahrenheit = -1;
                // Convert from Kelvin
                if (((String) unitDropdown.getSelectedItem()).equals("Kelvin")) {
                    tempKelvin    = (int) (inputTemp);
                    tempCelcius    = (int) (inputTemp - 273.15);
                    tempFahrenheit = (int) ((inputTemp - 273.15) * (9/5)  + 32);

                // Convert from Celsius
                } else if (((String) unitDropdown.getSelectedItem()).equals("Celsius")) {
                    tempKelvin     = (int) (inputTemp + 273.15);
                    tempCelcius    = (int) (inputTemp);
                    tempFahrenheit = (int) (inputTemp  * (9/5)  + 32);

                // Convert from Fahrenheit
                } else if (((String) unitDropdown.getSelectedItem()).equals("Fahrenheit")) {
                    tempKelvin     = (int) ((inputTemp - 32) * (5/9) + 273.15);
                    tempCelcius    = (int) ((inputTemp - 32) * (5/9));
                    tempFahrenheit = (int) ((inputTemp - 273.15) * (9/5)  + 32);

                // If none of the above was selected, it's an error...
                } else {
                    tempKelvin = 0;
                    tempCelcius = 0;
                    tempFahrenheit = 0;
                    warningLabel.setText("Oops, this doesn't look good!");
                }

                // Update labels
                kelvinLabel.setText(tempKelvin + " K");
                celsiusLabel.setText(tempCelcius + " C");
                fahrenheitLabel.setText(tempFahrenheit + " F");
                warningLabel.setText("");


            } else {
                warningLabel.setText("Input must be numeric!");
            }
        }
    });

    fahrenheitButton.setBounds(20, 45, 89, 23);
    contentPane.add(fahrenheitButton);