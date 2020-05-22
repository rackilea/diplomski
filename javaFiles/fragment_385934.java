private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){                                         

    if (jCheckBox1.isSelected()== true)
        jCheckBox1.equals(56);

    if (jCheckBox2.isSelected()== true)
        jCheckBox2.equals(50);

    if (jCheckBox3.isSelected()== true)
        jCheckBox3.equals(56);

    if (jCheckBox4.isSelected()== true)
        jCheckBox4.equals(56);

    if (jCheckBox5.isSelected()== true)
        jCheckBox5.equals(56);

    if (jCheckBox6.isSelected()== true)
        jCheckBox6.equals(56);

    new Form6().setVisible(true); // This statement will always run because it's not associated with a condition.

    else // Oops! Here is an else that is not associated with an if statement! This probably doesn't compile
        if (jCheckBox1.isSelected()== false) // This if is conditional on the else above.
            jCheckBox1.equals(0);

    if (jCheckBox2.isSelected()== false)
        jCheckBox2.equals(0);

    if (jCheckBox3.isSelected()== false)
        jCheckBox3.equals(0);

    if (jCheckBox4.isSelected()== false)
        jCheckBox4.equals(0);

    if (jCheckBox5.isSelected()== false)
        jCheckBox5.equals(0);

    if (jCheckBox6.isSelected()== false)
        jCheckBox6.equals(0);

    JOptionPane.showMessageDialog(this, "Please Choose An Option and Try Again");
} // I assume you mean to close the method