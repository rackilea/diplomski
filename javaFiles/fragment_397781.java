private void jComboBoxRefPointSelectorItemStateChanged(java.awt.event.ItemEvent evt)                                                           
{                                                               
    if (evt.getStateChange() == ItemEvent.SELECTED)
    {
        Object selected = jComboBoxRefPointSelector.getSelectedItem();
        ReferencePointObject selectedReferencePoint = (ReferencePointObject) selected;
        jTextFieldLat.setText(selectedReferencePoint.getLat());
        jTextFieldLong.setText(selectedReferencePoint.getLng());
    }
}