new Thread(new Runnable() {
    public void run() {
        YelpAPI yelp = new YelpAPI(
        getString(R.string.yelp_consumer_key),
        getString(R.string.yelp_consumer_secret),
        getString(R.string.yelp_token),
        getString(R.string.yelp_token_secret));

        String result = yelp.searchForBusinessesByLocation("bar", "San Jose, CA");
        System.out.println(result);
    }
 }).start();