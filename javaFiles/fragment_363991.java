List<Status> tweets = result.getTweets();
    List<Status> Stats=  tw.getHomeTimeline();
    for (Status tweet : tweets) {

        if(!(tweet.getUser().getScreenName().toString().equals("gh") || tweet.getUser().getScreenName().toString().equals("gh"))){

            boolean found = false;
            for (Status StatList : Stats) {  

                if(StatList.getTweetText().equals(tweet.getTweetText())){   
                    found = true;
                    break;
                    try {
                        System.out.println(tweet.getUser().getScreenName() );

                        Thread.sleep(2000);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }else{
                    // nothing here
                    // System.out.println("retweeted");
                }
            }
            if (found) // you can move this and the initialisation(boolean found = false) out side the upper if statement
                System.out.println("false");
            else
                System.out.println("turn");

        }else{
            System.out.println("derp blocked");
        }
    }