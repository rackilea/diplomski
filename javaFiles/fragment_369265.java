for(int i=0;i<10000;i++){                   
         messageSent++;              
         publisher.send(message);  
         if (messageSent % 1000 == 0) session.commit();              
    }
    session.commit();