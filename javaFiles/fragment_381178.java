public void onHandleIntent(Intent intent) {
      Runnable hashtagsTask = new Runnable() {
           @Override
           public void run() {
                for (int i = 0; i < hashtags.size(); i++) {
                     getHashtag(i);// do something, fetch hashtags, etc
                }
           }      
      };
      Runnable searchtagsTask = new Runnable() {
           @Override
           public void run() {
                // do something
           }
      };


      ExecutorService pool = Executors.newFixedThreadPool(3);
      pool.execute(hashtagsTask);
      pool.execute(searchtagsTask);
      // etc

      pool.awaitTermination();
}