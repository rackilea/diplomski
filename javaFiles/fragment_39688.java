if ( (((String) obj).length() > 4 ) && ( (String) obj).substring(0, 4).equals("////") ){

                    //first copy the users name so we can use it in our message:
                    String disconnectedUser = clientNames.get(index);
                    //now remove the disconnected user before you do anything else:
                    clientNames.remove(clientName);
                    //now you can send your message without causing the error because the disconnected client has been removed from the clientName list:
                    sendMsg(clientNames.get(index) + " has logged out of the chat room.\n");

                    sendArrayList();

                } //end of if