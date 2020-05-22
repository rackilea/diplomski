public void filllist() throws JSONException, IOException {        

    // remove all listeners
    ListSelectionListener[] listeners = serviceList.getListSelectionListeners();
    for (ListSelectionListener l : listeners) {
        serviceList.removeListSelectionListener(l);
    }

    // do your work
    model.removeAllElements();
    serviceURLJSONArray = connection.getSlaves();
    for (int i = 0; i < serviceURLJSONArray.length(); i++) {
        String slaveStatus = new Connection().getSlaveStatus(serviceURLJSONArray.getString(i));
        model.addElement("Service " +(i+1)+" "+slaveStatus);
    }

    // add them back
    for (ListSelectionListener l : listeners) {
        serviceList.addListSelectionListener(l);
    }

}