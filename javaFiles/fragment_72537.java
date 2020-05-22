public void onDataChange(DataSnapshot snapshot) {
    if (snapshot.getChildrenCount() == 0) {
        System.out.println("No Messages");
    } 
    else {
        for (DataSnapshot messageSnapshot: snapshot.getChildren()) {
            String message = messageSnapshot.getValue(String.class);
            messageDisplay.setText(messageDisplay.getText() + "\n" + message + "\n");
        }
    }
}