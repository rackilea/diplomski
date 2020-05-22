@GetMapping("/hello")
    public Mono<ResponseEntity<String>> publicHello() {
        return Mono.just(ResponseEntity.ok("Hello world!"));
    }

    @GetMapping("/pause/{duration}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> pause2(@PathVariable long duration) {
        LOGGER.info("Pausing for {} msec", duration);
        return (duration > 0 ? Mono.delay(Duration.ofMillis(duration)) : Mono.empty())
                .then()
                .doFinally(s -> LOGGER.info("Paused for {} msec", duration));
    }