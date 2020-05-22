public void createInterface(){
    //Instanciate some Swing components

    fillPhoneList();
    updateNamePanel();
}

private void fillPhoneList(){
    List<PhoneNumber> phoneList = model.getPhoneList();
    for(PhoneNumber phone : phoneList){
         phoneListView.add(phone);
    }
}