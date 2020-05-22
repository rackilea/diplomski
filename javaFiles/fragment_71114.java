class MyImplementation implements MyInterface {
  @Override
  List<FirebaseVisionFace> getFaceList() {
    final CompletableFuture<List<FirebaseVisionFace>> future = new CompletableFuture<>();
    final DetectorOfSomeKindYouDidNotSpecifyAbove detector = // ... get detector
    detector.detectInImage(image)
            .addOnSuccessListener(
                    new OnSuccessListener<List<FirebaseVisionFace>>() {
                        @Override
                        public void onSuccess(List<FirebaseVisionFace> faces) {
                            // Task completed successfully
                            future.complete(faces);
                        }
                    })
            .addOnFailureListener(
                    new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Task failed with an exception
                            future.completeExceptionally(e);
                        }
                    });
    try {
      return future.get(); // blocks until completion by one of the listeners above
    } catch (final RuntimeException throwMe) {
      throw throwMe;
    } catch (final InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw new IllegalStateException(interruptedException.getMessage(), interruptedException);
    } catch (final Exception everythingElse) {
      throw new IllegalStateException(everythingElse.getMessage(), everythingElse);
    }
  }
}