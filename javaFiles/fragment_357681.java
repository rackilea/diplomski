synchronized (this) {
            iterateClientsMap = new HashMap<ClientSocket, Client>(clientsMap);  
        }           

        for (Map.Entry<ClientSocket, Client> entry : iterateClientsMap.entrySet())      
        {                                                                                                   
            ClientSocket key = entry.getKey();
            //Client value = entry.getValue();              
            long diff = currentTime - key.getLastOnline();
            boolean isAvailable = false;
            try {
                isAvailable = (key.getSocket().getInputStream().available() > 0);
            } catch (IOException e) {
                e.printStackTrace();
            }               
            if ( diff > keepAlive)              
                removeClientSocket(key);
}