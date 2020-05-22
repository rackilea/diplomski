executor.shutdown();
try {
    executor.awaitTermination(100, TimeUnit.SECONDS);
}
catch (InterruptedException e) {
    // what should happen if timeout was hit
}

// image is complete here (if InterruptedException was not thrown)
g.drawImage(this.image, 0, 0, this);