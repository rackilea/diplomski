public void scanDirectory(String directory) {
    final CompletableFuture<Set<Video>> completableFuture = videoService.findFiles();

    completableFuture.thenAccept(results -> {
        log.info("uploading {} files", results.size());

        results.forEach(result -> firestore.collection("videos").document().create(result));
    });
}