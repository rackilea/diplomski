private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt)         
{                                           
    System.out.println("Combo Item Selected");
    comboitem = jComboBox2.getSelectedItem();
    if(null==comboitem)
       return ;

    combos = comboitem.toString();
    System.out.println(combos);
    objcombo.SearchProject(this, combos);
}