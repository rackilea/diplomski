while (db.result == null){
   try {
      Thread.sleep(100);
   } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   continue;
}