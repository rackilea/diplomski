//Declare and initialize the options that the comboboxes will have
String[] options = {"-Select-", "Item 1", "Item 2", "Item 3", "Item 4"};
//Declare and initialize an array that will hold the currently selected options in each combobox by index
//For example the currently selected value of comboBoxes[1] is selected[1]
String[] selected = {"-Select-", "-Select-", "-Select-", "-Select-"};

//Declare and initialize an array of comboBoxes. 
//Four comboboxes will be created all containing the options array
JComboBox[] comboBoxes = new JComboBox[4];
for(int i = 0; i < comboBox.length; i++) {
    comboBoxes[i] = new JComboBox(options);
}

private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
    //Loop through all of the comboboxes in comboBoxes
    for(int i = 0; i < comboBoxes.length; i++) {
        //Check to see if the current combobox in the array matches the source of your event
        if(evt.getSource() == comboBoxes[i]) {
            //Get the string value of the combobox that fired the event
            String currentSelection = (String)comboBoxes[i].getSelectedItem();
            //Make sure that the value actually changed
            if(!currentSelection.equals(selected[i]) {
                //If the previous value of the combobox was "-Select-" don't add it to all the other comboboxes
                if(!selected[i].equals(options[0])) {
                    //Add back the previous value to all comboboxes other than the one that fired the event
                    for(int j = 0; j < comboBoxes.length; j++) {
                        if(j != i) {
                            comboBoxes[j].addItem(selected[i]);
                        }
                    }
                }
                //If current value of the combobox is "-Select-" don't remove it from all other comboboxes
                if(!currentSelection.equals(options[0]) {
                    //Remove the current value from all comboboxes other than the one that fired the event
                    for(int j = 0; j < comboBoxes.length; j++) {
                        if(j != i) {
                            comboBoxes[j].removeItem(comboBoxes[i].getSelectedItem());
                        }
                    }
                }
            }
            //Set the selected item for the combobox that fired the event to the current value
            selected[i] = currentSelection;
        }
    }
}