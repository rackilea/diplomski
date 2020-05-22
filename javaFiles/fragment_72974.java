// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
Platform.runLater(
  () -> {
    // Update UI here.
  }
);