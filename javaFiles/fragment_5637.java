protected void addPrivateChatTab(String remoteNick, int port, boolean isHost) {
 FXMLLoader loader =
  new FXMLLoader(getClass().getResource("PrivateTab.fxml"));
 try {
  loader.setController(new PrivateChat(remoteNick, port, isHost));
  if (isHost) {
   associatedClient.connectRemoteUser(remoteNick, PrivateChat.getPort());
  }
  Tab privateChat = new Tab(remoteNick);
  SplitPane sp = loader.load();
  privateChat.setContent(sp);
  addPrivateChatTab(privateChat);
  } catch (IOException e) {
   e.printStackTrace();
}