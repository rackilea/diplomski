private void donePicking(){
ContactPickerRecyclerViewAdapter justToGetPlayerData = new 
      ContactPickerRecyclerViewAdapter();
justToGetPlayerData.donePickingSendPlayers();
Intent backToComposeMessage = new Intent(this,ComposeMessage.class);
startActivity(backToComposeMessage);