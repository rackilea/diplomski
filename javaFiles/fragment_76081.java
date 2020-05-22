public ImageManipulator(LinkedBlockingQueue<ImageBean> downloadedImagesBlockingQueue,
                        LinkedBlockingQueue<ImageBean> manipulatedImagesBlockingQueue,
                        AtomicInteger capacity,
                        ManipulatedData manipulatedData,
                        ReentrantLock downloaderReentrantLock,
                        ReentrantLock manipulatorReentrantLock,
                        Condition downloaderNotFull,
                        Condition manipulatorNotFull) {

    this.downloadedImagesBlockingQueue = downloadedImagesBlockingQueue;
    this.manipulatedImagesBlockingQueue = manipulatedImagesBlockingQueue;
    this.capacity = capacity;
    this.downloaderReentrantLock = downloaderReentrantLock;
    this.manipulatorReentrantLock = manipulatorReentrantLock;
    this.downloaderNotFull = downloaderNotFull;
    this.manipulatorNotFull = manipulatorNotFull;
    this.manipulatedData = manipulatedData;
}

@Override
public void run() {
    while (capacity.get() > 0) {
        downloaderReentrantLock.lock();
        if (capacity.get() > 0) { //checks if the value is updated.

            ImageBean imageBean = downloadedImagesBlockingQueue.poll();

            if (imageBean != null) { // will be null if no downloader finished is work (successfully downloaded or not)

                capacity.decrementAndGet();
                if (capacity.get() == 0) { //signal all the manipulators to wake up and stop waiting for downloaded images.
                    downloaderNotFull.signalAll();
                }
                downloaderReentrantLock.unlock();

                if (imageBean.getOriginalImage() != null) { // the downloader will set it null iff it failes to download it.

                     // business logic
                }

                manipulatedImagesBlockingQueue.add(imageBean);

                signalAllPersisters(); // signal the persisters (which has the same lock/unlock as this manipulator.

            } else {
                try {
                    downloaderNotFull.await(); //manipulator will wait for downloaded image - downloader will signalAllManipulators (same as signalAllPersisters() here) when an imageBean will be inserted to queue.
                    downloaderReentrantLock.unlock();
                } catch (InterruptedException e) {
                    logger.log(Level.ERROR, e.getMessage(), e);
                }
            }
        }
    }

    logger.log(Level.INFO, "Manipulator: " + Thread.currentThread().getId() + "  Ended Gracefully");
}

private void signalAllPersisters() {
    manipulatorReentrantLock.lock();
    manipulatorNotFull.signalAll();
    manipulatorReentrantLock.unlock();
}