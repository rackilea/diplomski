AtomicLong lastKey = new AtomicLong();
    Thread writingThread = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(100);
                long now = System.currentTimeMillis();
                long localLastKey = lastKey.updateAndGet(oldValue -> oldValue < now - 10000 ? now : oldValue);
                if (localLastKey == now) {
                    tenSecondBucket.put(now, "newEntry");
                } else {
                    tenSecondBucket.put(localLastKey, "updatedEntry@" + now);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });