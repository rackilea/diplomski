Integer getIntegerFromTextBox(Text textBox) {
    Integer integer;

    if (textBox.getText().trim().equals("")) { 
        integer = 0; 
    } else { 
        integer = Integer.parseInt(textBox.getText()); 
    }

    return integer;
}