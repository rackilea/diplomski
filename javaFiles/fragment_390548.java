@EventHandler
public void playerJoin(PlayerJoinEvent e){
  if(myMethodToCheckIfAPlayerIsTempBanned(e.getPlayer()){
    String msg = myMethodToGetPlayersBanMessage(e.getPlayer());
    e.getPlayer().kickPlayer(msg);
  }
}