public void sendCommand(String command, RelayThread source){
  for (int i=0;i<clients.size();i++){
     if (clients.get(i) != source) {
        clients.get(i).sendCommand(command);
     }
  }
}