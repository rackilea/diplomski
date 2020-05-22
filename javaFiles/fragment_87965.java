private void btMinusActionPerformed(java.awt.event.ActionEvent evt) {                                        
    // minus button
    firstNumber = Float.parseFloat(calScreen.getText());
    OP = "-";
    numberClick += 1;
    if (!calScreen.getText().equals("-") && numberClick == 2){
        btEqual.doClick();
    }
    else {
        calScreen.setText("-"); // <- What does this do?
    }
}