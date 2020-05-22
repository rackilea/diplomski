private void sendMessage(){
    mDatabaseReference= FirebaseDatabase.getInstance().getReference();
    if (mNewMessageField == null) {
        System.out.println("mNewMessageField is NULL");
    }
    Editable ed = mNewMessageField.getText();

    if (ed == null) {
        System.out.println("Editable is NULL");
    }
    String input = mNewMessageField.getText().toString();
    System.out.println("input=" + input);

    SingleMessage singleMessage = new SingleMessage(input, mDisplayName);
    mDatabaseReference.child("messages").push().setValue(singleMessage);
}