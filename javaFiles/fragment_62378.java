while (true) {
   String msg = getNewCreatedMessage(); // you get your messages from here
   int id = getNewCreatedMessageId();   // you get your rec's id from here
   Worker w = myHash(id);
   if (w == null) {   // create new Worker thread
      w = new Worker();
      new Thread(w).start();
   }
   w.queueMessage(msg);
}