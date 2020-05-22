if (updatePerson == null) {
    panelContainingFields.setVisible(false);
} else {
    jTextField11.setText(updatePerson.getFirstname());
    jTextField17.setText(updatePerson.getSurname());
    jTextField12.setText(updatePerson.getPersontype());
    jTextField16.setText(updatePerson.getGender());
    jSpinner5.setValue(updatePerson.getDateofbirth());
    panelContainingFields.setVisible(true);
}