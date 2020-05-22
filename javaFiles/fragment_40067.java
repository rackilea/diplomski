private class ComboBoxListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = destinationBox.getSelectedIndex();
        int selectedCol = originBox.getSelectedIndex();

        String text = fileData[selectedRow+1][selectedColumn+1];

        if (kilometersRadioButton.isSelected()) {
            text = String.valueOf(
                     MetricConverter.milesToKilometers(Double.valueOf(text)));
        }

        distanceText.setText(text);        
    }
}

private class RadioButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
        int selectedRow = destinationBox.getSelectedIndex();
        int selectedCol = originBox.getSelectedIndex();

        String text = fileData[selectedRow+1][selectedColumn+1];

        if (event.getSource() == kilometersRadioButton) {
            distanceLabel.setText("Distance (kilometers):");
            avgspeedLabel.setText("Avg. Speeg (kph): ");  

            text = String.valueOf(
                     MetricConverter.milesToKilometers(Double.valueOf(text)));
        } else if (event.getSource() == milesRadioButton) {
            distanceLabel.setText("Distance (miles): ");
            avgspeedLabel.setText("Avg. Speeg (mph): ");
        }

        distanceText.setText(text);
    }
}