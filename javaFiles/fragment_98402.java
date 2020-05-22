OUTER: for (row = 0; row < myEntries.size(); row++) {
    for (column = 0; column < myEntries.get(row).length; column++) {
        // If serial exists
        if (myEntries.get(row)[column].trim().equals(newSerial.getText())) {
            // break loop
            OptionPane.showMessageDialog(null, "Serial already exists!");
            break OUTER;
        // If the serial does not exist, write this new line to the end of the file
        } else if (!(myEntries.get(row)[column].trim().equals(newSerial.getText()))) {
            System.out.println(row);
            myEntries.add(new String[] { newSerial.getText(), dateFormat.format(newDate), newLocation.getText(), "", newAllocation, newCondition, newType.getText(), newComments.getText() });
        }

    }
}