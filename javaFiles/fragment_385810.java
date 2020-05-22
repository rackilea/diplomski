try {
        key = watcher.take();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    } catch (ClosedWatchServiceException e) {
        Thread.currentThread().interrupt();
    }