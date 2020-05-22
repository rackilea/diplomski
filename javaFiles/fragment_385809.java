try {
        key = watcher.take();
    } catch (InterruptedException e) {
        executorService.shutdown();
    } catch (ClosedWatchServiceException e) {
        executorService.shutdown();
    }