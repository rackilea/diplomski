private void mouseComboBoxActionPerformed(java.awt.event.ActionEvent evt) { 
    JComboBox jcb = (JComboBox) evt.getSource();
    String selectedItem = (String)jcb.getSelectedItem();
    if(selectedItem.equals("Transform")){
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
    } else {
        gm.setMode(ModalGraphMouse.Mode.PICKING);
    }
    vv.repaint();
}