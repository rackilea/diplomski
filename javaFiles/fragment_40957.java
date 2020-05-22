@PostMapping("/tweets")
public Mono<Void> postAllTweets(Flux<Tweet> tweetsFlux) {

    return tweetService.process(tweetsFlux.limitRate(10))
                       .then();
}