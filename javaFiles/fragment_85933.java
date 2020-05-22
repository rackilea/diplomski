if (a instanceof Problem) {
    proDeviceShort.setText(((Problem) a).getProDevDetShort());
    if (((Problem) a).getUrgency() == 1)
        listViewItem.setBackgroundColor(RED);
    if (((Problem) a).getUrgency() == 2) {
        listViewItem.setBackgroundColor(BLUE);
    }
    if (((Problem) a).getUrgency() == 3)
        listViewItem.setBackgroundColor(GREEN);
}
if (a instanceof Customer) {

    fName.setText(((Customer) a).getfName());
    lName.setText(((Customer) a).getlName());
    phone.setText(((Customer) a).getPhoneNum());

}