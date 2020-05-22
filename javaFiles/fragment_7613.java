service.submit(() -> {
        if (!Thread.interrupted()) {
            try {
                  customClass.send(url);
                  countDownLatch.countDown();
                } catch (Exception e) {
                   service.shutdownNow();
                }
        }

    });