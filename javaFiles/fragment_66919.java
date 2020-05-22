private void GetTweetsByKeywords()
     {

        TwitterStream twitterStream = new TwitterStreamFactory(config).getInstance();

                StatusListener statusListener = new StatusListener() {
                    private int count = 0;
                    private long originalTweetId = 0;

                    @Override
                        public void onStatus(Status status) {

                        // Here do whatever you want with the status object that is the       
                         //  tweet you got

                        } //end of the onStatus()
         }; //end of the listener

         FilterQuery fq = new FilterQuery();

         String keywords[] = {"sad","happy","joyful"};

         fq.track(keywords);


         twitterStream.addListener(statusListener);
         twitterStream.filter(fq);
    }