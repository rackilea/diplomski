private class ComboBoxListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        setCities(destinationBox.getSelectedIndex(), 
                  originBox.getSelectedIndex());
        updateDistanceText();
    }
}

private class RadioButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
        if (event.getSource() == kilometersRadioButton) {
            distanceLabel.setText("Distance (kilometers):");
            avgspeedLabel.setText("Avg. Speed (kph): ");
            setKm(true);
        } else if (event.getSource() == milesRadioButton) {
            distanceLabel.setText("Distance (miles): ");
            avgspeedLabel.setText("Avg. Speed (mph): ");
            setKm(false);
        }
        updateDistanceText();
    }
}