while (s.hasNextLine()) {
        String nextLine=s.nextLine();
        if (nextLine.contains("Twitter Web Client")) {
            twitterWebClient++;
        } else if (nextLine.contains("TweetDeck")) {
            tweetDeck++;
        } else if (nextLine.contains("Twitter for Android")) {
            android++;
        } else if (nextLine.contains("Twitter for iPhone")) {
            iphone++;
        } else {
            other++;
        }
}