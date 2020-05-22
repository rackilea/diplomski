@GetMapping("/tweets")
public Flux<Tweet> getAllTweets() {

    return tweetService.retreiveAll()
                       .limitRate(10);
}