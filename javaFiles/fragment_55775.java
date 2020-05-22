while (count <= rows) {//Loop until count less than or equal to rows
        if (myArray[0][count] == filmComboBox.getSelectedItem()) {
         //If it Never Satisfied Count won't be incremented
            developerComboBox.addItem(myArray[1][count]);
            count++;//Never Incremented
        }
    }