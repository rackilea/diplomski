public CompletableFuture<List<Event>> getFilteredEventsFaster(EventResearch eventResearch) {

        /* Collecting the list of all the async requests that build a List<Event>. */
        List<CompletableFuture<List<Event>>> completableFutures = eventsResearchApis.stream()
                .map(api -> getFilteredEventsAsync(api, eventResearch))
                .collect(Collectors.toList());

        /* Creating a single Future that contains all the Futures we just created ("flatmap"). */
        CompletableFuture<Void> allFutures =CompletableFuture.allOf(completableFutures
                .toArray(new CompletableFuture[eventsResearchApis.size()]));

        /* When all the Futures have completed, we join them to create merged List<Event>. */
        CompletableFuture<List<Event>> allCompletableFutures = allFutures
                .thenApply(future -> completableFutures.stream()
                            .map(CompletableFuture::join)
                            .flatMap(List::stream) // creating a List<Event> from List<List<Event>>
                            .collect(Collectors.toList())
                );

        return allCompletableFutures;
    }

    private CompletableFuture<List<Event>> getFilteredEventsAsync(UniformEventsResearchApi api,
            EventResearch eventResearch) {
        /* Manage the Exceptions here to ensure the wrapping Future returns the other calls. */
        return CompletableFuture.supplyAsync(() -> api.getFilteredEvents(eventResearch))
                .exceptionally(ex -> {
                    LOGGER.error("Extraction of events from API went wrong: ", ex);
                    return Collections.emptyList(); // gets managed in the wrapping Future
                });
    }