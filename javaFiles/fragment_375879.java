private void aggiungiTitolareButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       

    DefaultListModel lm2 = (DefaultListModel) listaTitolari.getModel();
    DefaultListModel lm1  = (DefaultListModel) listaRosa.getModel();
    if(lm2 == null)
    {
        lm2 = new DefaultListModel();
        listaTitolari.setModel(lm2);
    }
    lm2.addElement(listaTitolari.getSelectedValue());
    lm1.removeElement(listaTitolari.getSelectedValue());        
}