if (server1.getQueueLength() < server2.getQueueLength()) 
   currentServer = server1;
else if (server1.getQueueLength() > server2.getQueueLength()) 
   currentServer = server2;
else if (currentServer == server1) 
   currentServer = server2;
else 
   currentServer = server1;