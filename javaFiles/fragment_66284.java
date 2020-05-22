String[] messageParts = string.split();
String command = messageParts[0];

if("!ban".equalsIgnoreCase(command){
   ban(channel,messageParts[1])
   if(messageParts[2].isEmpty()){
      sendMessage(channel, "Banned " + messageParts[1]);
   }else{
      sendMessage(channel, "Banned " + messageParts[1] + " Reason: " + messageParts[2]);
   }
}